package com.example.ontapkhachhang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

import com.example.ulti.MydateDialog;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements MydateDialog.OnMydateChangeListener,View.OnClickListener{
    EditText edtName, edtDate,edtAddress, edtPhoneNumber;
    RadioButton rdbTienMat, rdbtnNganHang, rdbtnViDienTu;
    Button btnView;
    ImageButton imvDate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        addView();
        addEvent();
    }

    private void addView() {

        edtName = findViewById(R.id.edtName);
        edtDate = findViewById(R.id.edtDate);
        edtAddress = findViewById(R.id.edtAddress);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        rdbTienMat = findViewById(R.id.rdbtnTienMat);
        rdbTienMat.isChecked();
        rdbtnNganHang = findViewById(R.id.rdbtnNganHang);
        rdbtnViDienTu = findViewById(R.id.rbbtnViDienTu);
        imvDate = findViewById(R.id.imgDate);
        edtDate.setEnabled(false);
        btnView = findViewById(R.id.btnview);
        btnView.setOnClickListener(this);
    }

    @Override
    public void dateUpdate(Calendar newDate) {
        StringBuilder builder= new StringBuilder();
        builder.append(newDate.get(Calendar.DAY_OF_MONTH))
                .append("/")
                .append(newDate.get(Calendar.MONTH))
                .append("/")
                .append(newDate.get(Calendar.YEAR));
        edtDate.setText(builder.toString());
    }
    private String Phuongthuc()
    {
        rdbTienMat = findViewById(R.id.rdbtnTienMat);
        rdbtnNganHang = findViewById(R.id.rdbtnNganHang);
        rdbtnViDienTu = findViewById(R.id.rbbtnViDienTu);
        String text;
        if(rdbTienMat.isChecked())
        {
            text =" Tiền mặt";
            return text;
        }if(rdbtnNganHang.isChecked())
        {
            text =" Gửi ngân hàng";
            return text;
        }if(rdbtnViDienTu.isChecked())
        {
            text =" Ví điện tử";
            return text;
        }
        return null;
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this,docpretion.class);
        intent.putExtra("ThongTin",getThongTinKhachHang());
        startActivity(intent);
    }

    private void addEvent() {

        imvDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MydateDialog dateDialog = new MydateDialog(  MainActivity.this, MainActivity.this, Calendar.getInstance() );
                dateDialog.showDateDialog();
            };

        });



    }

    private void docPret() {

        getThongTinKhachHang();
    }

    public String getThongTinKhachHang()
    {
        String thongtin = "";
        thongtin = "chúc mừng" + edtName.getText().toString() +"\nSinh ngày" + edtDate.getText().toString() + "\n Số điện thoại: "+ edtPhoneNumber.getText().toString() + "\n Địa chỉ: "+ edtAddress.getText().toString()
                + "\n Phương thức thanh toán: " + Phuongthuc() ;
        return thongtin;

    }
}
