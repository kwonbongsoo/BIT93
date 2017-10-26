package fun;
import javax.crypto.AEADBadTagException;


public class AbstractMain {
	public static void main(String[] args) {
		AbstractTest at = new AbstractTest(){
			public void setName(String name){
				this.name = name;
			}
		};//�͸� inner Ŭ����
		InterA in = new InterA(){
			public void aa(){}
			public void bb(){}
		};
		AbstractExam ex = new AbstractExam() {
			//�ǹ̻��� �۽�Ʈ��Ʈ�� �������̵� �Ҳ��� �ϰ� ���Ҳ��� ��������� �ǹ�..
			//�̷��� ����..
		};
	}
}
