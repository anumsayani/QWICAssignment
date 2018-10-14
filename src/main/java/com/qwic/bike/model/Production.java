package com.qwic.bike.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

@EqualsAndHashCode(of = "productionId")
public class Production {

    @Getter
    @Setter
    private String productionId;

    @Getter
    @Setter
    private LocalDateTime startingDay;

    private LocalDateTime endDay;

    @Getter
    @Setter
    private int duration;


    public Production(){
        UUID uuid = UUID.randomUUID();

        ByteBuffer bb = ByteBuffer.wrap(new byte[16])
                .putLong(uuid.getMostSignificantBits())
                .putLong(uuid.getLeastSignificantBits());

        this.productionId =  Base64.getEncoder().encodeToString(bb.array());

    }

    public Production(LocalDateTime startingDay, int duration) {
        this();
        this.startingDay = startingDay;
        this.duration = duration;
    }

    public LocalDateTime getEndDay(){
        if(endDay == null) {
            this.endDay = startingDay.plusDays(duration-1);
        }
        return this.endDay;
    }

}
