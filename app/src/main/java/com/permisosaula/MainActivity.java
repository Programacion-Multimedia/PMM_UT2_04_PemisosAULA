package com.permisosaula;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int permisoSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if (permisoSMS == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permiso para SMS concedido",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Permiso para SMS no ha sido concedido",Toast.LENGTH_SHORT).show();
            int CODIGO_RESP = 100;
            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, CODIGO_RESP);
        }

        int permisoBiometrico = ContextCompat.checkSelfPermission(this, Manifest.permission.USE_BIOMETRIC);

        if (permisoBiometrico == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permiso para Biometria concedido",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Permiso para Biometria no ha sido concedido",Toast.LENGTH_SHORT).show();
        }

        int permisoMedia = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_MEDIA_LOCATION);

        if (permisoMedia == PackageManager.PERMISSION_DENIED) {

            int CODIGO_RESP = 200;
            Toast.makeText(this, "Permiso para Media no ha sido concedido",Toast.LENGTH_SHORT).show();
            requestPermissions(new String[]{Manifest.permission.ACCESS_MEDIA_LOCATION}, CODIGO_RESP);

        } else {
            Toast.makeText(this, "Permiso para Media ha sido concedido",Toast.LENGTH_SHORT).show();
        }

        int permisoInternet = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        if (permisoMedia == PackageManager.PERMISSION_DENIED) {

            int CODIGO_RESP = 300;
            Toast.makeText(this, "Permiso para Media no ha sido concedido",Toast.LENGTH_SHORT).show();
            requestPermissions(new String[]{Manifest.permission.INTERNET}, CODIGO_RESP);

        } else {
            Toast.makeText(this, "Permiso para Media ha sido concedido",Toast.LENGTH_SHORT).show();
        }

        int permisoContactos = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        if (permisoMedia == PackageManager.PERMISSION_DENIED) {

            int CODIGO_RESP = 400;
            Toast.makeText(this, "Permiso para Media no ha sido concedido",Toast.LENGTH_SHORT).show();
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, CODIGO_RESP);

        } else {
            Toast.makeText(this, "Permiso para Media ha sido concedido",Toast.LENGTH_SHORT).show();
        }

        int permisoUbicacion = ContextCompat.checkSelfPermission(this, Manifest.permission.LOCATION_HARDWARE);
        if (permisoMedia == PackageManager.PERMISSION_DENIED) {

            int CODIGO_RESP = 500;
            Toast.makeText(this, "Permiso para Media no ha sido concedido",Toast.LENGTH_SHORT).show();
            requestPermissions(new String[]{Manifest.permission.LOCATION_HARDWARE}, CODIGO_RESP);

        } else {
            Toast.makeText(this, "Permiso para Media ha sido concedido",Toast.LENGTH_SHORT).show();
        }

    }
}