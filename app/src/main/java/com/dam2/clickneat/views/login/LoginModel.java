package com.dam2.clickneat.views.login;

import com.dam2.clickneat.client.DataReceiver;
import com.dam2.clickneat.client.handlers.UsuarioHandler;
import com.dam2.clickneat.pojos.Usuario;

import java.util.List;

/**
 * Created by Pablo on 25/04/2017.
 */

public class LoginModel implements LoginContract.Model {

    private LoginContract.Presenter presenter;
    private UsuarioHandler usuarioHandler;


    public LoginModel(LoginContract.Presenter presenter){

        this.presenter      = presenter;
        this.usuarioHandler = new UsuarioHandler(new DataReceiver<Usuario>() {
            @Override
            public void onListReceived(List<Usuario> list) {

            }

            @Override
            public void onElementReceived(Usuario list) {

            }

            @Override
            public void onDataItemInsertedReceived(int id) {

            }

            @Override
            public void onDataNoErrorReceived(String noerror) {

            }

            @Override
            public void onDataErrorReceived(String error) {

                LoginModel.this.presenter.onErrorLogin(error);
            }

            @Override
            public void onLoginReceived(String token) {

                LoginModel.this.presenter.onLoginSuccess(token);
            }

        });
    }

    @Override
    public void loginUser(Usuario usuario) {

        usuarioHandler.loginUser(usuario);
    }
}
