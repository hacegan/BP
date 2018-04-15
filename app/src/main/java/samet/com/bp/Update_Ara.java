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

import static samet.com.bp.Benim_Tekil_Ara_Goster.odaara10butce;
import static samet.com.bp.Benim_Tekil_Ara_Goster.odaara12sure;
import static samet.com.bp.Benim_Tekil_Ara_Goster.odaara13numara;
import static samet.com.bp.Benim_Tekil_Ara_Goster.odaara14aciklama;
import static samet.com.bp.Benim_Tekil_Ara_Goster.odaara14baslik;
import static samet.com.bp.Benim_Tekil_Ara_Goster.odaara1bay;
import static samet.com.bp.Benim_Tekil_Ara_Goster.odaara3yas;
import static samet.com.bp.Benim_Tekil_Ara_Goster.odaara4meslek;
import static samet.com.bp.Benim_Tekil_Ara_Goster.odaara5evet;
import static samet.com.bp.Benim_Tekil_Ara_Goster.odaara6evet;

/**
 * Created by root on 15.04.2018.
 */

public class Update_Ara extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    ImageView imageView;
    EditText editText;
    static Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.update_ara);

        btn= (Button) findViewById(R.id.degkaydet);
        btn.setOnClickListener(this);

        editText= (EditText) findViewById(R.id.Tara_yayin_arayan);
        String ara_yayin_arayan=textView.getText().toString();
        editText.setText(ara_yayin_arayan+" "+odaara1bay);
        editText.addTextChangedListener(textWatcher);


                /*    imageView= (ImageView) findViewById(R.id.ara_yayin_resim);

                    if (!odaara2resim.equalsIgnoreCase("")) {
                        //Decoding the Image and display in ImageView
                        byte[] b = Base64.decode(odaara2resim, Base64.DEFAULT);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
                        imageView.setImageBitmap(bitmap);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"You don't have Image in SharedPreferences!", Toast.LENGTH_SHORT).show();
                    }
*/
        editText= (EditText) findViewById(R.id.Tara_yayin_yas);
        String ara_yayin_yas=textView.getText().toString();
        editText.setText(ara_yayin_yas+" "+odaara3yas);
        editText.addTextChangedListener(textWatcher);


        editText= (EditText) findViewById(R.id.Tara_yayin_meslek);
        String ara_yayin_meslek=textView.getText().toString();
        editText.setText(ara_yayin_meslek+" "+odaara4meslek);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tara_yayin_evcilvarmi);
        String ara_yayin_evcilvarmi=textView.getText().toString();
        editText.setText(ara_yayin_evcilvarmi+" "+odaara5evet);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tara_yayin_sigaravarmi);
        String ara_yayin_sigaravarmi=textView.getText().toString();
        editText.setText(ara_yayin_sigaravarmi+" "+odaara6evet);
        editText.addTextChangedListener(textWatcher);

                /*    textView= (TextView) findViewById(R.id.ara_yayin_yasaralik);
                    String ara_yayin_yasaralik=textView.getText().toString();
                    textView.setText(ara_yayin_yasaralik+" "+odaara8tv);*/

                /*    textView= (TextView) findViewById(R.id.ara_yayin_neredelive);
                    String ara_yayin_neredelive=textView.getText().toString();
                    textView.setText(ara_yayin_neredelive+" "+odaarahangiil);*/

        editText= (EditText) findViewById(R.id.Tara_yayin_butce);
        String ara_yayin_butce=textView.getText().toString();
        editText.setText(ara_yayin_butce+" "+odaara10butce);
        editText.addTextChangedListener(textWatcher);

        // textView= (TextView) findViewById(R.id.Tara_yayin_hazirtarih);
        //  String ara_yayin_hazirtarih=textView.getText().toString();
        // textView.setText(ara_yayin_hazirtarih+" "+odaara11tarih);

        editText= (EditText) findViewById(R.id.Tara_yayin_konaksure);
        String ara_yayin_konaksure=textView.getText().toString();
        editText.setText(ara_yayin_konaksure+" "+odaara12sure);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tara_yayin_telefonno);
        String ara_yayin_telefonno=textView.getText().toString();
        editText.setText(ara_yayin_telefonno+" "+odaara13numara);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tara_yayin_ilanbaslik);
        String ara_yayin_ilanbaslik=textView.getText().toString();
        editText.setText(ara_yayin_ilanbaslik+" "+odaara14baslik);
        editText.addTextChangedListener(textWatcher);

        editText= (EditText) findViewById(R.id.Tara_yayin_ilanaciklama);
        String ara_yayin_ilanaciklama=textView.getText().toString();
        editText.setText(ara_yayin_ilanaciklama+" "+odaara14aciklama);
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
