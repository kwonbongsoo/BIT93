"use strict"
const net = require('net')
window.$ = window.jQuery = require('jquery')
var host = $('#host'),
port = $('#port'),
connectBtn = $('#connectBtn'),
closeBtn = $('#closeBtn')

var socket = new net.Socket()
socket.setTimeout(500)
closeBtn.css('display', 'none')

socket.on('connect', () => {
  connectBtn.css('display', 'none')
  closeBtn.css('display', '')
})
socket.on('close', () => {
  connectBtn.css('display', '')
  closeBtn.css('display', 'none')
})
socket.on('data', (data) => {
  $('#response').val(data.toString())
})

socket.on('error', () => {
  alert(error.message())
})

socket.on('timeout', () => {
  alert('서버가 응답하지 않습니다')
  socket.destroy()
})



connectBtn.click(() => {
  socket.connect(port.val(), host.val())
})

closeBtn.click(() => {
  socket.destroy()
})
