package com.laohu.administrator.yao10.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.laohu.administrator.yao10.R;
import com.laohu.administrator.yao10.model.Conf;
import com.laohu.administrator.yao10.model.User;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2016/9/26.
 */

public class Login extends Activity implements View.OnClickListener{
    private EditText et_name,et_password;
    private Button bn_login,bn_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.lojin);
        Bmob.initialize(this, Conf.APP_ID);
        initView();
    }
   private void initView(){
       et_name= (EditText) findViewById(R.id.et_name);
       et_password= (EditText) findViewById(R.id.et_password);
       bn_login= (Button) findViewById(R.id.bn_login);
       bn_reg= (Button) findViewById(R.id.bn_reg);
       bn_login.setOnClickListener(this);
       bn_reg.setOnClickListener(this);
   }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bn_login:
                User user=new User();
                user.setUsername(et_name.getText().toString().trim());
                user.setPassword(et_password.getText().toString().trim());
                user.login(new SaveListener<Object>() {
                    @Override
                    public void done(Object o, BmobException e) {
                        if(e==null){
                            Toast.makeText(Login.this,"登录成功",Toast.LENGTH_SHORT).show();
                           Intent intent1=new Intent(Login.this,first.class);
                           startActivity(intent1);


                        }else {
                            Toast.makeText(Login.this,"登录失败",Toast.LENGTH_SHORT).show();


                        }

                    }
                });
                break;
            case R.id.bn_reg:
                Intent intent=new Intent(Login.this,reg.class);
                startActivity(intent);
                break;
            default:
                break;


        }

    }
}
