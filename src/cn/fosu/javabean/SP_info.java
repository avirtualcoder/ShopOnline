package cn.fosu.javabean;

public class SP_info {
private int id;
private int sp_type;
private String sp_name;
private String old_price;
private String new_price;
private String sp_info;
private String sp_img;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getSp_type() {
	return sp_type;
}
public void setSp_type(int sp_type) {
	this.sp_type = sp_type;
}
public String getSp_name() {
	return sp_name;
}
public void setSp_name(String sp_name) {
	this.sp_name = sp_name;
}
public String getOld_price() {
	return old_price;
}
public void setOld_price(String old_price) {
	this.old_price = old_price;
}
public String getNew_price() {
	return new_price;
}
public void setNew_price(String new_price) {
	this.new_price = new_price;
}
public String getSp_info() {
	return sp_info;
}
public void setSp_info(String sp_info) {
	this.sp_info = sp_info;
}
public String getSp_img() {
	return sp_img;
}
public void setSp_img(String sp_img) {
	this.sp_img = sp_img;
}
@Override
public String toString() {
	return "SP_infojava [id=" + id + ", sp_type=" + sp_type + ", sp_name="
			+ sp_name + ", old_price=" + old_price + ", new_price=" + new_price
			+ ", sp_info=" + sp_info + ", sp_img=" + sp_img + "]";
}
}
