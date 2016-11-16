package com.laohu.administrator.yao10.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.laohu.administrator.yao10.R;
import com.laohu.administrator.yao10.model.DRUG;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;


/**
 * Created by Administrator on 2016/9/27.
 */

public class first extends Activity {
 private Myadapter myadapter;
  private   ListView mMsgListView;

    EditText ET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first);
        ET= (EditText) findViewById(R.id.chaxun);

        // initListView();

    }
    public void  CHAXUN(View view) {

        if (ET.getText().toString().trim()!=null) {
            final BmobQuery<DRUG> query = new BmobQuery<DRUG>();
                //查询NAME字段的值含有“输入框的数据”的数据

                 query.addWhereEqualTo("CLASSES",ET.getText().toString().trim());

               //query.addWhereContains("NAME", ET.getText().toString().trim());
              query.setLimit(100);
               //执行查询方法
                query.findObjects( new FindListener<DRUG>() {
                @Override
                  public void done(List<DRUG> list, BmobException e) {
                    if (e == null) {
                        mMsgListView= (ListView) findViewById(R.id.list_view01);
                        myadapter=new Myadapter(first.this,list);
                        mMsgListView.setAdapter( myadapter);
                        Toast.makeText(first.this, "查询成功：共" + list.size() + "条数据。", Toast.LENGTH_LONG).show();
//                        for (DRUG drug : list) {
//                            drug.getNAME();
//                            drug.getCLASSES();
//                            drug.getEFFECT();
//                            drug.getFLAVOR_MERIDIAN();
//                            drug.getSUBCLASS();
//                            list.add(drug);
//                        }

                    } else {
                        Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                    }
                }


            });
        }else
        {
            Toast.makeText(first.this, "搜索框不能为空，请输入关键字", Toast.LENGTH_SHORT).show();
        }
    }

    private class Myadapter extends BaseAdapter {
        private List<DRUG> list;
        Context context;
        public Myadapter(Context context,List<DRUG> list){
            this.context = context;
            this.list=list;
        }
        @Override
        public View getView(final int position, View convertView,
                            ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context)
                        .inflate(R.layout.item, null);
                holder = new ViewHolder();
                holder.NAME = (TextView) convertView
                        .findViewById(R.id.NAME_i);
                holder.CLASS = (TextView) convertView
                        .findViewById(R.id.CLASS_i);
                holder.EFFECT = (TextView) convertView
                        .findViewById(R.id.EFFECT_i);
                holder.FLAVOR_MERIDIAN = (TextView) convertView
                        .findViewById(R.id.FLAVOR_MERIDIAN_i);
                holder.SUBCLASS = (TextView) convertView
                        .findViewById(R.id.SUBCLASS_i);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            DRUG drug = (DRUG) getItem(position);
            holder.NAME.setText(drug.getNAME());
            holder.CLASS.setText(drug.getCLASSES());
            holder.EFFECT.setText(drug.getEFFECT());
            holder.FLAVOR_MERIDIAN.setText(drug.getFLAVOR_MERIDIAN());
            holder.SUBCLASS.setText(drug.getSUBCLASS());
            return convertView;
        }
        class ViewHolder {
            TextView NAME;
            TextView CLASS;
            TextView EFFECT;
            TextView FLAVOR_MERIDIAN;
            TextView SUBCLASS;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

    }

}
