package com.toy.rxandroiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {


    private Observable observable;
    private Subscriber<String> subscriber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStop() {
        Subscription subscribe = observable.subscribe(subscriber);
        if (!subscribe.isUnsubscribed()) {
            subscribe.unsubscribe();
        }
        super.onStop();
    }

    public void click(View view) {
        String[] names=new String[]{"Hello","YKYK","ol","ni"};
        Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i("OBC",s);
            }
        });

       /* //观察者 observer
        subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.i("OBS", "onCompleted");
                Log.i("OBS", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("OBS", "onError");
            }

            @Override
            public void onNext(String s) {
                Log.i("OBS", "observer" + s);
            }
        };


        //可观察者  ,  被观察者
        observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("observable = helloOnNext");
                subscriber.onNext("observable = worldOnNext");
                subscriber.onNext("observable = AndroidOnNext");
                subscriber.onCompleted();
            }
        });

        observable.subscribe(subscriber);*/
    }
}

