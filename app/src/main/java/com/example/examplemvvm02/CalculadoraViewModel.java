package com.example.examplemvvm02;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculadoraViewModel extends ViewModel {
    private Calculadora calculadora;
    private MutableLiveData<String> resultado;


    public CalculadoraViewModel(){
        calculadora = new Calculadora();


        resultado = new MutableLiveData<>();
    }//


    public LiveData<String> getResultado(){
        return  resultado;
    }//


    public void calcular(double n1,double n2,String op){
        double cr = calculadora.calcular(n1,n2,op);
        resultado.setValue(String.valueOf(cr));
    }//


}//class
