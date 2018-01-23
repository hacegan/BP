package samet.com.bp;

import android.app.Activity;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.content.Intent;

public class IntroActivity extends Activity implements View.OnClickListener {
private ViewPager mPager;

private int[] layouts={R.layout.slide1,R.layout.slide2,R.layout.slide3,R.layout.slide4,R.layout.slide5};

    private MpagerAdapter mpagerAdapter;

    private LinearLayout Dots_Layout;
    private ImageView[] dots;

private Button btnNext,btnSkip;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        if(new PreferenceManager(this).checkPreference()){
            loadHome();
        }



        if(Build.VERSION.SDK_INT >=19){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        else{
getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }


        setContentView(R.layout.activity_intro);

        mPager= (ViewPager) findViewById(R.id.viewPager);
        mpagerAdapter=new MpagerAdapter(layouts,this);
        mPager.setAdapter(mpagerAdapter);

        Dots_Layout= (LinearLayout) findViewById(R.id.dotsLayout);
        btnNext= (Button) findViewById(R.id.btnNext);
        btnSkip= (Button) findViewById(R.id.btnSkip);
        btnNext.setOnClickListener(this);
        btnSkip.setOnClickListener(this);
        createDots(0);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
createDots(position);
if(position==layouts.length-1){
    btnNext.setText("Başlayalım");
    btnSkip.setVisibility(View.INVISIBLE);
}
else{
    btnNext.setText("Sonraki");
    btnSkip.setVisibility(View.VISIBLE);
}


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });





    }



    private void createDots(int current_position)
    {
if(Dots_Layout!=null)
        Dots_Layout.removeAllViews();
        dots=new ImageView[layouts.length];

for(int i=0;i<layouts.length;i++){
    dots[i]=new ImageView(this);
    if(i==current_position){
        dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
    }
    else{
        dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots));
    }


    LinearLayout.MarginLayoutParams params=new LinearLayout.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT,ViewGroup.MarginLayoutParams.WRAP_CONTENT);
    params.setMargins(4,0,4,0);
Dots_Layout.addView(dots[i],params);


}



    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btnNext:
                loadNextSlide();
                break;
            case R.id.btnSkip:
                loadHome();
                new PreferenceManager(this).writePreference();
                break;




        }


    }

    private void loadHome(){

startActivity(new Intent(this,MainActivity.class));//skipte gidiceği yer
finish();
    }

    private void loadNextSlide(){
int next_slide=mPager.getCurrentItem()+1;
        if(next_slide<layouts.length)
        {
mPager.setCurrentItem(next_slide);
        }
else{
            loadHome();
            new PreferenceManager(this).writePreference();
        }
    }










}
