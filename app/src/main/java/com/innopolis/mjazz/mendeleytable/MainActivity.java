package com.innopolis.mjazz.mendeleytable;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

    ElementFragmentFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * Инициализация активити, указание нужного лэйаут фала
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Создание фабрики фрагментов элементов
         */
        factory = new ElementFragmentFactory(getFragmentManager(), this);
        /**
         * Вызов функции из фабрики для заполнения лэйаута фрагментами
         */
        factory.initElements();
    }


}
