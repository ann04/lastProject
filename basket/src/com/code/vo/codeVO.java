package com.code.vo;

import java.sql.Date;

public class codeVO {
		private int productnum;
		private String producttype;
		private String productname;
		private int price;
		private String color;
		
		public int getProductnum() {
			
			return productnum;
		}
		public void setProductnum(int productnum) {
			this.productnum = productnum;
		}
		public String getProducttype() {
			return producttype == null ? "" : producttype.trim();
		}
		public void setProducttype(String producttype) {
			this.producttype = producttype;
		}
		public String getProductname() {
			return productname == null ? "" : productname.trim();
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getColor() {
			return color == null ? "" : color.trim();
		}
		public void setColor(String color) {
			this.color = color;
		}
		
		
	}