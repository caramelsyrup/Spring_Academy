package com.example.demo3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "tbl_order")
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderid;
	
	@Column(name = "order_name")
	private String ordername;
	
	private String note;
	
	private int price;
	
	
	// 외래키가 있기에, 여기를 주인 테이블로
	// 외래키 설정이 되면서, 컬럼명은 지칭한대로.
	@ManyToOne(fetch = FetchType.LAZY)	// 다 : 1 관계이다. 지연전략사용. 한번에 다 보여주지 않고, 해당 자료를 요청할때 보여줌
	@JoinColumn(name = "user_id")
	private User user;
	
}
