package com.haxxj.bluetoothscale.DBUtils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class Item_info {
    @Id(autoincrement = true)
    private Long primid;
    @Unique
    @NotNull
    private String item_id;//货号
    private String item_code;//自编码
    private String item_name;//商品名称
    private String item_unit;//商品单位
    private String item_spection;//规格
    private String item_iscount;//是否计数
    private Integer item_counting_base_number;//计数基数
    private String item_expiration_date;//保质期
    private Integer item_sn;//流水号
    private Integer item_step_number;//步长数
    private String item_batch_number;//批号
    private String item_GB;//标准
    private String item_product_code;//生产编号
    private Double item_price;//单价
    private Double item_discount;//折扣
    private Double item_member_price;//会员价
    private Double item_set_number; //设定数量
    private Double item_upper;//上允差
    private Double item_downward;//下允差
    private String item_scale_model;//称量方式（0-稳定，1-合格）
    private String item_bill_id;//小票模板号
    private String item_up_bill_id;//上差小票号
    private String item_down_bill_id;//下差小票号
    private String item_label_id;//标签号
    private String item_up_label_id;//上差标签号
    private String item_down_label_id;//下差标签号
    private String item_remark;//备注
    private String item_explain;//说明
    private String item_custom1;//自定义一
    private String item_custom2;//自定义二
    private String item_custom3;//自定义三
    private String item_custom4;//自定义四
    private String item_custom5;//自定义五
    private String item_create_time;//创建时间
    private String item_modify_time;//修改时间
    private String item_del_time;//删除时间
    private Integer item_status; //商品状态
    @Generated(hash = 1692784652)
    public Item_info(Long primid, @NotNull String item_id, String item_code,
            String item_name, String item_unit, String item_spection,
            String item_iscount, Integer item_counting_base_number,
            String item_expiration_date, Integer item_sn, Integer item_step_number,
            String item_batch_number, String item_GB, String item_product_code,
            Double item_price, Double item_discount, Double item_member_price,
            Double item_set_number, Double item_upper, Double item_downward,
            String item_scale_model, String item_bill_id, String item_up_bill_id,
            String item_down_bill_id, String item_label_id, String item_up_label_id,
            String item_down_label_id, String item_remark, String item_explain,
            String item_custom1, String item_custom2, String item_custom3,
            String item_custom4, String item_custom5, String item_create_time,
            String item_modify_time, String item_del_time, Integer item_status) {
        this.primid = primid;
        this.item_id = item_id;
        this.item_code = item_code;
        this.item_name = item_name;
        this.item_unit = item_unit;
        this.item_spection = item_spection;
        this.item_iscount = item_iscount;
        this.item_counting_base_number = item_counting_base_number;
        this.item_expiration_date = item_expiration_date;
        this.item_sn = item_sn;
        this.item_step_number = item_step_number;
        this.item_batch_number = item_batch_number;
        this.item_GB = item_GB;
        this.item_product_code = item_product_code;
        this.item_price = item_price;
        this.item_discount = item_discount;
        this.item_member_price = item_member_price;
        this.item_set_number = item_set_number;
        this.item_upper = item_upper;
        this.item_downward = item_downward;
        this.item_scale_model = item_scale_model;
        this.item_bill_id = item_bill_id;
        this.item_up_bill_id = item_up_bill_id;
        this.item_down_bill_id = item_down_bill_id;
        this.item_label_id = item_label_id;
        this.item_up_label_id = item_up_label_id;
        this.item_down_label_id = item_down_label_id;
        this.item_remark = item_remark;
        this.item_explain = item_explain;
        this.item_custom1 = item_custom1;
        this.item_custom2 = item_custom2;
        this.item_custom3 = item_custom3;
        this.item_custom4 = item_custom4;
        this.item_custom5 = item_custom5;
        this.item_create_time = item_create_time;
        this.item_modify_time = item_modify_time;
        this.item_del_time = item_del_time;
        this.item_status = item_status;
    }
    @Generated(hash = 40670733)
    public Item_info() {
    }
    public Long getPrimid() {
        return this.primid;
    }
    public void setPrimid(Long primid) {
        this.primid = primid;
    }
    public String getItem_id() {
        return this.item_id;
    }
    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }
    public String getItem_code() {
        return this.item_code;
    }
    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }
    public String getItem_name() {
        return this.item_name;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public String getItem_unit() {
        return this.item_unit;
    }
    public void setItem_unit(String item_unit) {
        this.item_unit = item_unit;
    }
    public String getItem_spection() {
        return this.item_spection;
    }
    public void setItem_spection(String item_spection) {
        this.item_spection = item_spection;
    }
    public String getItem_iscount() {
        return this.item_iscount;
    }
    public void setItem_iscount(String item_iscount) {
        this.item_iscount = item_iscount;
    }
    public Integer getItem_counting_base_number() {
        return this.item_counting_base_number;
    }
    public void setItem_counting_base_number(Integer item_counting_base_number) {
        this.item_counting_base_number = item_counting_base_number;
    }
    public String getItem_expiration_date() {
        return this.item_expiration_date;
    }
    public void setItem_expiration_date(String item_expiration_date) {
        this.item_expiration_date = item_expiration_date;
    }
    public Integer getItem_sn() {
        return this.item_sn;
    }
    public void setItem_sn(Integer item_sn) {
        this.item_sn = item_sn;
    }
    public Integer getItem_step_number() {
        return this.item_step_number;
    }
    public void setItem_step_number(Integer item_step_number) {
        this.item_step_number = item_step_number;
    }
    public String getItem_batch_number() {
        return this.item_batch_number;
    }
    public void setItem_batch_number(String item_batch_number) {
        this.item_batch_number = item_batch_number;
    }
    public String getItem_GB() {
        return this.item_GB;
    }
    public void setItem_GB(String item_GB) {
        this.item_GB = item_GB;
    }
    public Double getItem_price() {
        return this.item_price;
    }
    public void setItem_price(Double item_price) {
        this.item_price = item_price;
    }
    public Double getItem_discount() {
        return this.item_discount;
    }
    public void setItem_discount(Double item_discount) {
        this.item_discount = item_discount;
    }
    public Double getItem_member_price() {
        return this.item_member_price;
    }
    public void setItem_member_price(Double item_member_price) {
        this.item_member_price = item_member_price;
    }
    public Double getItem_set_number() {
        return this.item_set_number;
    }
    public void setItem_set_number(Double item_set_number) {
        this.item_set_number = item_set_number;
    }
    public Double getItem_upper() {
        return this.item_upper;
    }
    public void setItem_upper(Double item_upper) {
        this.item_upper = item_upper;
    }
    public Double getItem_downward() {
        return this.item_downward;
    }
    public void setItem_downward(Double item_downward) {
        this.item_downward = item_downward;
    }
    public String getItem_scale_model() {
        return this.item_scale_model;
    }
    public void setItem_scale_model(String item_scale_model) {
        this.item_scale_model = item_scale_model;
    }
    public String getItem_label_id() {
        return this.item_label_id;
    }
    public void setItem_label_id(String item_label_id) {
        this.item_label_id = item_label_id;
    }
    public String getItem_up_label_id() {
        return this.item_up_label_id;
    }
    public void setItem_up_label_id(String item_up_label_id) {
        this.item_up_label_id = item_up_label_id;
    }
    public String getItem_down_label_id() {
        return this.item_down_label_id;
    }
    public void setItem_down_label_id(String item_down_label_id) {
        this.item_down_label_id = item_down_label_id;
    }
    public String getItem_product_code() {
        return this.item_product_code;
    }
    public void setItem_product_code(String item_product_code) {
        this.item_product_code = item_product_code;
    }
    public String getItem_remark() {
        return this.item_remark;
    }
    public void setItem_remark(String item_remark) {
        this.item_remark = item_remark;
    }
    public String getItem_explain() {
        return this.item_explain;
    }
    public void setItem_explain(String item_explain) {
        this.item_explain = item_explain;
    }
    public String getItem_custom1() {
        return this.item_custom1;
    }
    public void setItem_custom1(String item_custom1) {
        this.item_custom1 = item_custom1;
    }
    public String getItem_custom2() {
        return this.item_custom2;
    }
    public void setItem_custom2(String item_custom2) {
        this.item_custom2 = item_custom2;
    }
    public String getItem_custom3() {
        return this.item_custom3;
    }
    public void setItem_custom3(String item_custom3) {
        this.item_custom3 = item_custom3;
    }
    public String getItem_custom4() {
        return this.item_custom4;
    }
    public void setItem_custom4(String item_custom4) {
        this.item_custom4 = item_custom4;
    }
    public String getItem_custom5() {
        return this.item_custom5;
    }
    public void setItem_custom5(String item_custom5) {
        this.item_custom5 = item_custom5;
    }
    public String getItem_create_time() {
        return this.item_create_time;
    }
    public void setItem_create_time(String item_create_time) {
        this.item_create_time = item_create_time;
    }
    public String getItem_modify_time() {
        return this.item_modify_time;
    }
    public void setItem_modify_time(String item_modify_time) {
        this.item_modify_time = item_modify_time;
    }
    public String getItem_del_time() {
        return this.item_del_time;
    }
    public void setItem_del_time(String item_del_time) {
        this.item_del_time = item_del_time;
    }
    public Integer getItem_status() {
        return this.item_status;
    }
    public void setItem_status(Integer item_status) {
        this.item_status = item_status;
    }
    public String getItem_bill_id() {
        return this.item_bill_id;
    }
    public void setItem_bill_id(String item_bill_id) {
        this.item_bill_id = item_bill_id;
    }
    public String getItem_up_bill_id() {
        return this.item_up_bill_id;
    }
    public void setItem_up_bill_id(String item_up_bill_id) {
        this.item_up_bill_id = item_up_bill_id;
    }
    public String getItem_down_bill_id() {
        return this.item_down_bill_id;
    }
    public void setItem_down_bill_id(String item_down_bill_id) {
        this.item_down_bill_id = item_down_bill_id;
    }
}
