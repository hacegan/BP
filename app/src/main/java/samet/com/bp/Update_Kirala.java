package samet.com.bp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala10var;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala11evet;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala13yas;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala14numara;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala15aciklama;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala15baslik;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala1mulktur;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala2ilanveren;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala3adres;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala7aidat;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala7bkat;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala7esya;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala7kat;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala7kira;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala7m2;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala7oda;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala8tarih;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala9erkeksayi;
import static samet.com.bp.Benim_Tekil_Kira_Goster.kirala9kizsayi;

/**
 * Created by root on 15.04.2018.
 */

public class Update_Kirala extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    ImageView imageView;
    EditText editText;
   static Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.update_kirala);

        btn= (Button) findViewById(R.id.degkaydet);
        btn.setOnClickListener(this);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_mulktur);
        String kirala_yayin_mulktur=textView.getText().toString();
        editText.setText(kirala_yayin_mulktur+" "+kirala1mulktur);
editText.addTextChangedListener(textWatcher);


        editText= (EditText) findViewById(R.id.Tkirala_yayin_ilanverentur);
        String kirala_yayin_ilanverentur=textView.getText().toString();
        editText.setText(kirala_yayin_ilanverentur+" "+kirala2ilanveren);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_adres);
        String kirala_yayin_adres=textView.getText().toString();
        editText.setText(kirala_yayin_adres+" "+kirala3adres);
        editText.addTextChangedListener(textWatcher);

                 /*   imageView= (ImageView) findViewById(R.id.kirala_yayin_resim);

                    if (!kirala6resim.equalsIgnoreCase("")) {
                        //Decoding the Image and display in ImageView
                        byte[] b = Base64.decode(kirala6resim, Base64.DEFAULT);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
                        imageView.setImageBitmap(bitmap);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"You don't have Image in SharedPreferences!", Toast.LENGTH_SHORT).show();
                    }
*/


        editText= (EditText) findViewById(R.id.Tkirala_yayin_m2);
        String kirala_yayin_m2=textView.getText().toString();
        editText.setText(kirala_yayin_m2+" "+kirala7m2);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_odasayi);
        String kirala_yayin_odasayi=textView.getText().toString();
        editText.setText(kirala_yayin_odasayi+" "+kirala7oda);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_bkat);
        String kirala_yayin_bkat=textView.getText().toString();
        editText.setText(kirala_yayin_bkat+" "+kirala7bkat);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_katsayi);
        String kirala_yayin_katsayi=textView.getText().toString();
        editText.setText(kirala_yayin_katsayi+" "+kirala7kat);
        editText.addTextChangedListener(textWatcher);


        editText= (EditText) findViewById(R.id.Tkirala_yayin_esyalimi);
        String kirala_yayin_esyalimi=textView.getText().toString();
        editText.setText(kirala_yayin_esyalimi+" "+kirala7esya);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_aidat);
        String kirala_yayin_aidat=textView.getText().toString();
        editText.setText(kirala_yayin_aidat+" "+kirala7aidat);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_kira);
        String kirala_yayin_kira=textView.getText().toString();
        editText.setText(kirala_yayin_kira+" "+kirala7kira);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_odauyguntarih);
        String kirala_yayin_odauyguntarih=textView.getText().toString();
        editText.setText(kirala_yayin_odauyguntarih+" "+kirala8tarih);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_erkeksayi);
        String kirala_yayin_erkeksayi=textView.getText().toString();
        editText.setText(kirala_yayin_erkeksayi+" "+kirala9erkeksayi);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_kizsayi);
        String kirala_yayin_kizsayi=textView.getText().toString();
        editText.setText(kirala_yayin_kizsayi+" "+kirala9kizsayi);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_evcilvarmi);
        String kirala_yayin_evcilvarmi=textView.getText().toString();
        editText.setText(kirala_yayin_evcilvarmi+" "+kirala10var);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_sigaravarmi);
        String kirala_yayin_sigaravarmi=textView.getText().toString();
        editText.setText(kirala_yayin_sigaravarmi+" "+kirala11evet);
        editText.addTextChangedListener(textWatcher);

              /*      textView= (TextView) findViewById(R.id.kirala_yayin_kimlelive);
                    String kirala_yayin_kimlelive=textView.getText().toString();
                    // textView.setText(kirala_yayin_kimlelive+" kirala1mulktur");*/

        editText= (EditText) findViewById(R.id.Tkirala_yayin_hangiyas);
        String kirala_yayin_hangiyas=textView.getText().toString();
        editText.setText(kirala_yayin_hangiyas+" "+kirala13yas);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_no);
        String kirala_yayin_no=textView.getText().toString();
        editText.setText(kirala_yayin_no+" "+kirala14numara);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_baslik);
        String kirala_yayin_baslik=textView.getText().toString();
        editText.setText(kirala_yayin_baslik+" " + kirala15baslik);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tkirala_yayin_aciklama);
        String kirala_yayin_aciklama=textView.getText().toString();
        editText.setText(kirala_yayin_aciklama+" "+kirala15aciklama);
        editText.addTextChangedListener(textWatcher);

    }

    private TextWatcher textWatcher = new TextWatcher() {

        public void afterTextChanged(Editable s) {
            btn.setEnabled(true);
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {

        }
    };


    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(),"İlan Başarıyla Güncellendi",Toast.LENGTH_SHORT);
    }
}
