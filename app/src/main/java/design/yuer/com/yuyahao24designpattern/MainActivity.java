package design.yuer.com.yuyahao24designpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import butterknife.ButterKnife;
import butterknife.OnClick;
import design.yuer.com.yuyahao24designpattern.activity.factory.YuerSimpleFactoryActivity;
import design.yuer.com.yuyahao24designpattern.utils.ActivityUtils;

/**
 * Android 水波纹显示进度效果:
 * https://blog.csdn.net/u014452224/article/details/55193542
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn01,R.id.btn02,R.id.btn03,R.id.btn04,R.id.btn05,R.id.btn06,R.id.btn07,R.id.btn08,R.id.btn09,R.id.btn010,R.id.btn011, R.id.btn012,R.id.btn013})
    public void  onClick(View view){
           switch (view.getId()){
               case R.id.btn01:
                   ActivityUtils.showActivity(MainActivity.this,YuerSimpleFactoryActivity.class);
                   break;
               case R.id.btn02:

                   break;
               case R.id.btn03:

                   break;
                   case R.id.btn04:
                   break;
                  case R.id.btn05:
                   break;
                  case R.id.btn06:
                   break;
                    case R.id.btn07:
                   break;
               case R.id.btn08:
                   break;
                   case R.id.btn09://
                   break;
               case R.id.btn010://
                   break;
              case R.id.btn011://
                   break;
                case R.id.btn012://
                   break;
               case R.id.btn013://
                   break;
           }
    }
}
