package com.nightscout.android.dexcom.records;

import com.nightscout.android.dexcom.Utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;

public class GenericTimestampRecord {

    private final int OFFSET_SYS_TIME = 0;
    private final int OFFSET_DISPLAY_TIME = 4;
    private Date systemTime;
    private Date displayTime;

    public GenericTimestampRecord(byte[] packet) {
        int st = ByteBuffer.wrap(packet).order(ByteOrder.LITTLE_ENDIAN).getInt(OFFSET_SYS_TIME);
        systemTime = Utils.receiverTimeToDate(st);
        int dt = ByteBuffer.wrap(packet).order(ByteOrder.LITTLE_ENDIAN).getInt(OFFSET_DISPLAY_TIME);
        displayTime = Utils.receiverTimeToDate(dt);
    }

    public Date getSystemTime() {
        return systemTime;
    }

    public Date getDisplayTime() {
        return displayTime;
    }

}