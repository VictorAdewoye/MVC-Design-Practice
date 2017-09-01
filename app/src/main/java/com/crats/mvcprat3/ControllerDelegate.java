package com.crats.mvcprat3;

/**
 * Created by Victor on 2017-06-12.
 */



public interface ControllerDelegate {
    void failure(String show);
    void success(String show);
    void clientSuccess(String show);
    void clientFailure(String error);
}

