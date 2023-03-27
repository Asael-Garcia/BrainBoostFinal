package com.example.brainboost.Login.helpers.interfaces;

import com.example.brainboost.Login.helpers.requests.HomeRequests;

public interface FetchCallback<T> {
    public void onSuccess(T response);
}
