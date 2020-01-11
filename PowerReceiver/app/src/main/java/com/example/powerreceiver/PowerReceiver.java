package com.example.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

public class PowerReceiver extends BroadcastReceiver {

    ImageView imageView;

    public PowerReceiver(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case Intent.ACTION_POWER_CONNECTED:
                imageView.setImageResource(R.drawable.charging);
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                imageView.setImageResource(R.drawable.discharging);
                break;
        }
    }
}
