package com.kutaverse.demo.dto;

import com.kutaverse.demo.domain.MapRequestType;
import com.kutaverse.demo.domain.Status;
import com.kutaverse.demo.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserRequestDto {
    private MapRequestType mapRequestType;
    private String userId;
    private Double positionX;
    private Double positionY;
    private Double positionZ;
    private Double rotationPitch;
    private Double rotationYaw;
    private Double rotationRoll;
    private Double velocityX;
    private Double velocityY;
    private Double velocityZ;
    private Status status;

    public User toEntity(){
        return User.builder()
                .userId(userId)
                .positionX(positionX)
                .positionY(positionY)
                .positionZ(positionZ)
                .rotationPitch(rotationPitch)
                .rotationYaw(rotationYaw)
                .rotationRoll(rotationRoll)
                .velocityX(velocityX)
                .velocityY(velocityY)
                .velocityZ(velocityZ)
                .status(status)
                .build();
    }
}
