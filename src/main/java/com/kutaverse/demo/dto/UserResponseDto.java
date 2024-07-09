package com.kutaverse.demo.dto;

import com.kutaverse.demo.domain.Status;
import com.kutaverse.demo.domain.User;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserResponseDto {

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



    public static UserResponseDto toDto(User user){
        return builder()
                .userId(user.getUserId())
                .positionX(user.getPositionX())
                .positionY(user.getPositionY())
                .positionZ(user.getPositionZ())
                .rotationPitch(user.getRotationPitch())
                .rotationRoll(user.getRotationRoll())
                .rotationYaw(user.getRotationYaw())
                .velocityX(user.getVelocityX())
                .velocityY(user.getVelocityY())
                .velocityZ(user.getVelocityZ())
                .status(user.getStatus())
                .build();
    }
}
