var express = require('express')
var bodyParser = require('body-parser')
var path = require('path')
var cons = require('consolidate');

var passport = require('passport');
var session = require('session');
var flash = require('flash');
var async = require('async');

var userSchema = mysql.Schema({
  email: {type:String, required: true, unique: true},
  nickname:{type:String, required: true, unique: true}
  password:{type:String, required: true}
  createdAt: {type:Date, default: Date.now}
});

var User = mysql.model('user',userSchema)


var app = express()



// 웹브라우저가 요청하는 파일이 어떤 폴더에 있는지 지정한다.
app.use(express.static('public'))

// POST 요청 데이터 분석기를 등록한다.
// => 이 분석기를 등록해야만 POST 요청으로 들어온 데이터를 꺼낼 수 있다.
app.use(bodyParser.urlencoded({extended: true}))

// => http://localhost:8888/lecture/.... 요청을 처리할 라우터를 등록한다.
app.use('/study', require('./control/study-control'))


app.use(flash())
app.use(session({secret: 'MySecret'}))
app.use(passport.initialize())
app.use(passport.session())

passport.serializeUser(function(user,done) {
  done(null, user.id)
})
passport.deserializeUser(function(id, done) {
  User.findById(id, function(err, user) {
    done(err, uwer)
  })
})

var LocalStrategy = require('passport-local').Strategy
passport.use('local-login',
new LocalStrategy ({
  usernameField: 'email',
  passwordField: 'password',
  passReqToCallback: true
},
function(request, email, password, done) {
  User.findOne({ 'email' : emial}, function (err, user) {
    if (err) return done(err);

    if (!user) {
      req.flash("emial", req.body.email);
      return done(null, false, req.flash('loginError', 'no user found'));
    }
    if (user.password != password) {
      req.flash("email", req.body.emial);
      return done(null, false, req.flash('loginError', 'Password does not match'));

    }
    return done(null, user)
  })
}
)
)

app.get('/', function (req, res) {
  res.redirect('/posts')
})
app.get('/login', function (request, response) {
  res.render('login/login', {email: req.flash("email")[0],
              loginError: request.flash('loginError')})
})
app.post('/login',
  funtion (request, response, next) {
    request.flash("email")
    if(request.body.email.length == 0 || request.body.password.length ==0) {
      request.flash("email", req.body.email)
      request.flash("loginError", "Please enter both email and password.");
      response.redirect('/login')
    } else {
      next();
    }
  }, passport.authenticate('local-login', {
    successRedirect: '/posts',
    failureRedirect: '/login',
    failureFlash : true
  })
)

app.get('/logout', function(request, response) {
  request.logout();
  response.redirect('/');
})


//set user router
app.get('/users/new', function (req, res) {
  response.render('users/new', {
    formData: request.flash('formData')[0],
    emailError: request.flash('emailError')[0],
    nicknameError: request.flash('nicknameEroor')[0],
    passwordError: request.flash('passwordError')[0]
  })
})//new

app.post('/user', checkUserRegValidation, function(request, response, next) {
  User.create(request.body.user, function (error, user) {
    if(error) return response.json({success:false, message: err})
    response.redirect('/login');
  })
})//create

app.get('/users/:id', function(req, res) {
  User.findById(req.params.id, function (err, user) {
    if(err) return res.json({success: false, message: err})

  })
}) //show

app.get('/users/:id/edit', function(req, res) {
  User.findById(req.params.id, function (err, user) {
    if(err) return res.json({success: false, message: err})
    response.render('users/edit', {
      user: user;
      formData: request.flash('formData')[0],
      emailError: request.flash('emailError')[0],
      nicknameError: request.flash('nicknameEroor')[0],
      passwordError: request.flash('passwordError')[0]
    })
  })
})// edit

app.put('/users/:id', checkUserRegValidation, function(req,res) {
  user.findById(req.params.id, req.body.user, function (err, user) {
    if(err) return res.json({success: false, message: err})
    if(req.body.user.password == user.password) {
      if(req.body.user.newPassword) {
        req.body.user.password = req.user.newPassword
      } else {
        delete req.body.user.Password
      }
      User.findByIdAndUpdate(req.params.id, req.body.user, function (err, user) {
        if(err) reutnr res.json({success: false, message: err})
        res.redirect('/users/' + req.params.id)
      })
    } else {
      req.flash("formData", req.body.user)
      req.flash("passwordError", "- Invalid password")
      res.redirect('/users' + req.params.id + "/edit")
    }
  })
}) //update

app.get('/posts', function(req,res){
  Post.find({}).sort('-createdAt').exec(function (err,posts) {
    if(err) return res.json({success:false, message:err});
    res.render("posts/index", {data:posts, user:req.user});
  });
}); // index
app.get('/posts/new', function(req,res){
  res.render("posts/new");
}); // new

function checkUserRegValidation(req, res, next) {
  var isValid = true
  async.waterfall (
    [function(callback) {
      User.findOne({
        email: req.body.user.email,
        _id: {$ne: mysql.Types.ObjectId(req.params.id)}},
        function(err, user) {
          if(user) {
            isValid = false;
            req.flash("emailError", "- This email is already resistered")
            }
            callback(null, isValid)
            }
          };
        }, function (isValid, callback) {
          User.findOne({
            nickname: req.body.user.nickname,
            _id: {$ne: mysql.Types.ObjectId(req.params.id)},
            function(err, user) {
              if(user) {
                isValid = false;
                req.flash("nicknameError", "err");
              }
              callback(null, isValid)
            }
          )
      }], function (err, Invalid) {
        if(err) return res.json({success:"flase", message: err})
        if(isValid) {
          return next();
        } else {
          req.flash("formData", req.body.user)
          res.redirect("back")
        }
      }

    };
  
}


app.listen(8080, function() {
  console.log('서버가 시작되었습니다.')
})
















//
