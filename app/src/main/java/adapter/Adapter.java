package adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.haxxj.bluetoothscale.R;
import com.haxxj.bluetoothscale.Utils.Utils;

import org.w3c.dom.Text;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import view.SlidingButtonView;

/**
 * 适配器    Created by Administrator on 2017/2/3.
 */


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> implements SlidingButtonView.IonSlidingButtonListener{
    private List<HashMap<String, Object>> itemList=new ArrayList<HashMap<String, Object>>();
    private Context lContext;   //上下文
    public SlidingButtonView mMenu;
    public Adapter(Context context, ArrayList<HashMap<String, Object>> list) {
        lContext = context;//定义上下文
        itemList = list;//定义用于存储数据的数组
        mIDeleteBtnClickListener = (IonSlidingViewClickListener) context;// 定义上下文
    }

    /**
     * 返回数据集中的项目总数
     */
    @Override
    public int getItemCount(){
        return itemList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView item_id,item_name,item_spection,item_unit,item_scale_model,item_create_time,item_modify_time,item_remark;             //删除按钮
        public TextView btn_Delete,btn_modify;             //删除按钮
        public TextView name, info;               //编号文字
        public ImageView img;                   //图标
        public ViewGroup layout_content;       //图标与编号的布局
        public SlidingButtonView slidingButtonView;
        //获取相关控件
        public MyViewHolder(View itemView) {
            super(itemView);
            btn_Delete = (TextView) itemView.findViewById(R.id.tv_delete);
            btn_modify = (TextView) itemView.findViewById(R.id.tv_modify);
            //设置内容
            item_id = (TextView) itemView.findViewById(R.id.item_id);
            item_name = (TextView) itemView.findViewById(R.id.item_name);
            item_unit = (TextView) itemView.findViewById(R.id.item_unit);
            item_spection = (TextView) itemView.findViewById(R.id.item_spection);
            item_scale_model = (TextView) itemView.findViewById(R.id.item_scale_model);
            //item_create_time = (TextView) itemView.findViewById(R.id.item_create_time);
            item_modify_time = (TextView) itemView.findViewById(R.id.item_modify_time);
            item_remark = (TextView) itemView.findViewById(R.id.item_remark);
            layout_content = (ViewGroup) itemView.findViewById(R.id.layout_content);
            slidingButtonView = (SlidingButtonView) itemView;
            slidingButtonView.setSlidingButtonListener(Adapter.this);
        }
    }
    /**
     * 设置列表菜单中子项所显示的内容
     */
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final MyViewHolder viewHolder = (MyViewHolder) holder;
        //设置图标
//        String s = Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/"+itemList.get(position).get("item_img").toString();
//        Bitmap bitmap = BitmapFactory.decodeFile(s);
//        holder.img.setImageBitmap(bitmap);
       // holder.img.setImageURI(Uri.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/Camera/"+itemList.get(position).get("item_img").toString())));
       // holder.img.setBackgroundResource(Integer.parseInt(itemList.get(position).get("item_img").toString()));
        //设置编号
        holder.item_id.setText(itemList.get(position).get("item_id").toString());
        //设置名称
        holder.item_name.setText(itemList.get(position).get("item_name").toString());
        //设置商品单位
        holder.item_unit.setText(itemList.get(position).get("item_unit").toString());
        //设置商品规格
        holder.item_spection.setText(itemList.get(position).get("item_spection").toString());
        //设置称重方式
        holder.item_scale_model.setText(itemList.get(position).get("item_scale_model").toString());
        //设置建立时间
       // holder.item_create_time.setText(itemList.get(position).get("item_create_time").toString());
        //设置修改时间
        holder.item_modify_time.setText(itemList.get(position).get("item_modify_time").toString());
        //设置备注
        holder.item_remark.setText(itemList.get(position).get("item_remark").toString());


        //设置内容布局的宽为屏幕宽度
        holder.layout_content.getLayoutParams().width = Utils.getScreenWidth(lContext);
        //单击列表事件
        holder.layout_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIDeleteBtnClickListener.onItemClick(view,holder.getLayoutPosition());
            }
        });

        holder.btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIDeleteBtnClickListener.onDeleteBtnCilck(view,holder.getLayoutPosition());
            }
        });
        holder.btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIDeleteBtnClickListener.onDetailBtnClick(view,holder.getLayoutPosition());
            }
        });
//        holder.layout_content.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int n = holder.getLayoutPosition();
//               // Toast.makeText(lContext, "您点了"+n+"行！", Toast.LENGTH_SHORT).show();
//                //收起左滑菜单
//                holder.slidingButtonView.closeMenu();
//               }
//        });

        //删除按钮的事件，单击后删除整行
//        holder.btn_Delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int n = holder.getLayoutPosition();     //获取要删除行的位置
//                removeData(n);                          //删除列表中的子项
//            }
//        });
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
        //获取列表中，每行的布局文件
        View view = LayoutInflater.from(lContext).inflate(R.layout.recyclerview_item, arg0, false);//定义容器视图
        MyViewHolder holder = new MyViewHolder(view);           //
        return holder;
    }
    /**     * 删除菜单打开信息接收     */
    @Override
    public void onMenuIsOpen(View view) {
        mMenu = (SlidingButtonView) view;
    }
    /**
     * 滑动或者点击了Item监听
     * @param slidingButtonView
     */
    @Override
    public void onDownOrMove(SlidingButtonView slidingButtonView) {
        if(menuIsOpen()){
            if(mMenu != slidingButtonView){
                closeMenu();
            }
        }
    }




    /**
     * 删除列表中子项
     */
    public void removeData(int position) {
        itemList.remove(position);   //删除信息
        notifyItemRemoved(position);    //删除列表

    }

    /**     * 关闭菜单     */
    public void closeMenu() {
        mMenu.closeMenu();
        mMenu = null;
    }
    /**     * 判断是否有菜单打开     */
    public Boolean menuIsOpen() {
        if(mMenu != null){
            return true;
        }else {
            return false;
        }
    }
    public interface IonSlidingViewClickListener {
        void onItemClick(View view, int position);
        void onDeleteBtnCilck(View view, int position);
        void onDetailBtnClick(View view, int position);
    }
    private IonSlidingViewClickListener mIDeleteBtnClickListener;

    public void setmIdeleteBtnClickListener(IonSlidingViewClickListener Listener){
        mIDeleteBtnClickListener = Listener;
    }
    private String rounding(String s){
        float f= Float.parseFloat(s);
        DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
        String p=decimalFormat.format(f);//format 返回的是字符串
        return p;
    }



}

