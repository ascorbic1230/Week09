package com.example.week09;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity2 extends Activity {

    ArrayAdapter<String> adapterMainSubjects;
    ListView myMainListView;
    Context context;
    SingleItem selectedNewsItem;
//    String[][] myUrlCaptionMenu;
//    String[] myUrlCaption;
//    String[] myUrlAddress;

    public static String niceDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EE MMM d, yyyy",
                Locale.US);
        return sdf.format(new Date()); //Monday Apr 7, 2014
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent callingIntent = getIntent();
        Bundle myBundle = callingIntent.getExtras();
        int trang = myBundle.getInt("trang");
        String[][] myUrlCaptionMenu;
        String[] myUrlCaption;
        String[] myUrlAddress;

        if (trang == 1) {
            myUrlCaptionMenu = new String[][]{
                    {"https://vnexpress.net/rss/the-gioi.rss", "Thế giới"},
                    {"https://vnexpress.net/rss/thoi-su.rss", "Thời sự"},
                    {"https://vnexpress.net/rss/kinh-doanh.rss", "Kinh doanh"},
                    {"https://vnexpress.net/rss/phap-luat.rss", "Pháp luật"},
                    {"https://vnexpress.net/rss/giai-tri.rss", "Giải trí"},
                    {"https://vnexpress.net/rss/the-thao.rss", "Thể thao"},
                    {"https://vnexpress.net/rss/giao-duc.rss", "Giáo dục"}
            };
        }
        else if (trang == 2)
        {
            myUrlCaptionMenu = new String[][]{
                    {"https://thanhnien.vn/rss/video/thoi-su-333.rss", "Thời sự"},
                    {"https://thanhnien.vn/rss/video/phong-su-349.rss", "Phóng sự"},
                    {"https://thanhnien.vn/rss/video/giai-tri-334.rss", "Giải trí"},
                    {"https://thanhnien.vn/rss/video/mon-ngon-350.rss", "Món ngon"},
                    {"https://thanhnien.vn/rss/video/video-the-thao-335.rss", "Thể thao"},
                    {"https://thanhnien.vn/rss/video/the-gioi-348.rss", "Thế giới"},
                    {"https://thanhnien.vn/rss/video/truc-tuyen-347.rss", "Trực tuyến"},
                    {"https://thanhnien.vn/rss/thoi-su/chinh-tri-227.rss", "Chính trị"},
                    {"https://thanhnien.vn/rss/thoi-su/phap-luat-5.rss", "Pháp luật"},
                    {"https://thanhnien.vn/rss/thoi-su/dan-sinh-176.rss", "Dân sinh"}
            };
        }
        else {
            myUrlCaptionMenu = new String[][]{
                    {"https://baophapluat.vn/rss/thoi-su-276.rss", "Thời sự"},
                    {"https://baophapluat.vn/rss/tu-phap-25.rss", "Tư pháp"},
                    {"https://baophapluat.vn/rss/kinh-te-13.rss", "kinh tế"},
                    {"https://baophapluat.vn/rss/kinh-doanh-1375.rss", "kinh doanh"},
                    {"https://baophapluat.vn/rss/giao-duc-1326.rss", "Giáo dục"},
                    {"https://baophapluat.vn/rss/moi-truong-1339.rss", "Môi trường"},
                    {"https://baophapluat.vn/rss/giai-tri-1286.rss", "Giải trí"}
            };
        }
        myUrlCaption = new String[myUrlCaptionMenu.length];
        myUrlAddress = new String[myUrlCaptionMenu.length];



        for (int i=0; i<myUrlAddress.length; i++) {
            myUrlAddress[i] = myUrlCaptionMenu[i][0]; myUrlCaption[i] = myUrlCaptionMenu[i][1];
        }
        context = getApplicationContext();
        this.setTitle("VNExpress Headline News\n" + niceDate() );
        myMainListView = (ListView)this.findViewById(R.id.myListView);
        myMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> _av, View _v, int _index, long _id) {
                String urlAddress = myUrlAddress[_index], urlCaption = myUrlCaption[_index];
                Intent callShowHeadlines = new Intent(MainActivity2.this, ShowHeadlines.class);
                Bundle myData = new Bundle();
                myData.putString("urlAddress", urlAddress);
                myData.putString("urlCaption", urlCaption);
                callShowHeadlines.putExtras(myData);
                startActivity(callShowHeadlines);
            }
        });
        adapterMainSubjects = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myUrlCaption);
        myMainListView.setAdapter(adapterMainSubjects);
    }//onCreate
}