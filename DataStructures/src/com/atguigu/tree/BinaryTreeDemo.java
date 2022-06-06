package com.atguigu.tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		//����Ҫ����һ�Ŷ�����
		BinaryTree binaryTree = new BinaryTree();
		//������Ҫ�Ľ��
		HeroNode root = new HeroNode(1, "�ν�");
		HeroNode node2 = new HeroNode(2, "����");
		HeroNode node3 = new HeroNode(3, "¬����");
		HeroNode node4 = new HeroNode(4, "�ֳ�");
		HeroNode node5 = new HeroNode(5, "��ʤ");
//		HeroNode node6 = new HeroNode(6, "����");
//		HeroNode node7 = new HeroNode(7, "�Ƴ�");
//		HeroNode node8 = new HeroNode(8, "���");
//		HeroNode node9 = new HeroNode(9, "����");
//		HeroNode node10 = new HeroNode(10, "��Τ");
//		HeroNode node11 = new HeroNode(11, "����");
//		HeroNode node12 = new HeroNode(12, "����");
		//˵�����������ֶ������ö���������������ѧϰ�ݹ�ķ�ʽ����������
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);
//		node2.setLeft(node6);
//		node2.setRight(node7);
//		node6.setLeft(node8);
//		node7.setLeft(node9);
//		node7.setRight(node10);
//		node5.setRight(node11);
//		node4.setLeft(node12);
		binaryTree.setRoot(root);
		

//		System.out.println("ǰ�����"); // 1,2,3,5,4           1\2\6\8\7\9\10\3\5\11\4\12
//		binaryTree.preOrder();
//
//		System.out.println("�������");
//		binaryTree.infixOrder(); // 2,1,5,3,4                  8\6\2\9\7\10\1\5\11\3\12\4
//
//		System.out.println("�������");
//		binaryTree.postOrder(); // 2,5,4,3,1                   8\6\9\10\7\2\11\5\12\4\3\1
		
		//ǰ�����
		//ǰ������Ĵ��� ��4 
//		System.out.println("ǰ�������ʽ~~~");
//		HeroNode resNode = binaryTree.preOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("�ҵ��ˣ���ϢΪ no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("û���ҵ� no = %d ��Ӣ��", 5);
//		}
		
		//�����������
		//�������3��
//		System.out.println("���������ʽ~~~");
//		HeroNode resNode = binaryTree.infixOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("�ҵ��ˣ���ϢΪ no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("û���ҵ� no = %d ��Ӣ��", 5);
//		}
		
		//�����������
		//����������ҵĴ���  2��
//		System.out.println("���������ʽ~~~");
//		HeroNode resNode = binaryTree.postOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("�ҵ��ˣ���ϢΪ no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("û���ҵ� no = %d ��Ӣ��", 5);
//		}
		
		//����һ��ɾ�����
		
		System.out.println("ɾ��ǰ,ǰ�����");
		binaryTree.preOrder(); //  1,2,3,5,4
		binaryTree.delNode(5);
		//binaryTree.delNode(3);
		System.out.println("ɾ����ǰ�����");
		binaryTree.preOrder(); // 1,2,3,4
		
		
		
	}

}

//����BinaryTree ������
class BinaryTree {
	private HeroNode root;

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	//ɾ�����
	public void delNode(int no) {
		if(root != null) {
			//���ֻ��һ��root���, ���������ж�root�ǲ��Ǿ���Ҫɾ�����
			if(root.getNo() == no) {
				root = null;
			} else {
				//�ݹ�ɾ��
				root.delNode(no);
			}
		}else{
			System.out.println("����������ɾ��~");
		}
	}
	//ǰ�����
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}
	
	//�������
	public void infixOrder() {
		if(this.root != null) {
			this.root.infixOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}
	//�������
	public void postOrder() {
		if(this.root != null) {
			this.root.postOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}
	
	//ǰ���������ָ���ڵ�
	public HeroNode preOrderSearch(int no) {
		if(root != null) {
			return root.preOrderSearch(no);
		} else {
			return null;
		}
	}
	//�����������ָ���ڵ�
	public HeroNode infixOrderSearch(int no) {
		if(root != null) {
			return root.infixOrderSearch(no);
		}else {
			return null;
		}
	}
	//�����������ָ���ڵ�
	public HeroNode postOrderSearch(int no) {
		if(root != null) {
			return this.root.postOrderSearch(no);
		}else {
			return null;
		}
	}
}

//�ȴ���HeroNode ���
class HeroNode {
	private int no;
	private String name;
	private HeroNode left; //Ĭ��null
	private HeroNode right; //Ĭ��null
	public HeroNode(int no, String name) {
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HeroNode getLeft() {
		return left;
	}
	public void setLeft(HeroNode left) {
		this.left = left;
	}
	public HeroNode getRight() {
		return right;
	}
	public void setRight(HeroNode right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	
	//�ݹ�ɾ�����
	//1.���ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ�
	//2.���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ��������
	public void delNode(int no) {
		
		//˼·
		/*
		 * 	1. ��Ϊ���ǵĶ������ǵ���ģ������������жϵ�ǰ�����ӽ���Ƿ���Ҫɾ����㣬������ȥ�жϵ�ǰ�������ǲ�����Ҫɾ�����.
			2. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.left = null; ���Ҿͷ���(�����ݹ�ɾ��)
			3. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
			4. �����2�͵�3��û��ɾ����㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ��
			5.  �����4��Ҳû��ɾ����㣬��Ӧ�������������еݹ�ɾ��.

		 */
		//2. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.left = null; ���Ҿͷ���(�����ݹ�ɾ��)
		if(this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		//3.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
		if(this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		//4.���Ǿ���Ҫ�����������еݹ�ɾ��
		if(this.left != null) {
			this.left.delNode(no);
		}
		//5.��Ӧ�������������еݹ�ɾ��
		if(this.right != null) {
			this.right.delNode(no);
		}
	}
	
	//��дǰ������ķ���
	public void preOrder() {
		System.out.println(this); //����������
		//�ݹ���������ǰ�����
		if(this.left != null) {
			this.left.preOrder();
		}
		//�ݹ���������ǰ�����
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	//�������
	public void infixOrder() {
		
		//�ݹ����������������
		if(this.left != null) {
			this.left.infixOrder();
		}
		//��������
		System.out.println(this);
		//�ݹ����������������
		if(this.right != null) {
			this.right.infixOrder();
		}
	}
	//�������
	public void postOrder() {
		if(this.left != null) {
			this.left.postOrder();
		}
		if(this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
	
	//ǰ���������ָ���ڵ�
	/**
	 * 
	 * @param no ����no
	 * @return ����ҵ��ͷ��ظ�Node ,���û���ҵ����� null
	 */
	public HeroNode preOrderSearch(int no) {
		System.out.println("����ǰ�����");
		//�Ƚϵ�ǰ����ǲ���
		if(this.no == no) {
			return this;
		}
		//1.���жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
		//2.�����ݹ�ǰ����ң��ҵ���㣬�򷵻�
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		if(resNode != null) {//˵�������������ҵ�
			return resNode;
		}
		//1.��ݹ�ǰ����ң��ҵ���㣬�򷵻أ�������жϣ�
		//2.��ǰ�Ľ������ӽڵ��Ƿ�Ϊ�գ�������գ���������ҵݹ�ǰ�����
		if(this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
		return resNode;
	}
	
	//�����������ָ���ڵ�
	public HeroNode infixOrderSearch(int no) {
		//�жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.infixOrderSearch(no);
		}
		if(resNode != null) {
			return resNode;
		}
		System.out.println("�����������");
		//����ҵ����򷵻أ����û���ҵ����ͺ͵�ǰ���Ƚϣ�������򷵻ص�ǰ���
		if(this.no == no) {
			return this;
		}
		//������������ҵݹ���������
		if(this.right != null) {
			resNode = this.right.infixOrderSearch(no);
		}
		return resNode;
		
	}
	
	//�����������ָ���ڵ�
	public HeroNode postOrderSearch(int no) {
		
		//�жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�������
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.postOrderSearch(no);
		}
		if(resNode != null) {//˵�����������ҵ�
			return resNode;
		}
		
		//���������û���ҵ��������������ݹ���к����������
		if(this.right != null) {
			resNode = this.right.postOrderSearch(no);
		}
		if(resNode != null) {
			return resNode;
		}
		System.out.println("����������");
		//�������������û���ҵ����ͱȽϵ�ǰ����ǲ���
		if(this.no == no) {
			return this;
		}
		return resNode;
	}
	
}

//


