package org.kryun.symbol.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImportDTO {

    private Long importId;
    private Long blockId;
    private String name;
    private String packageName;
    private String className;
    private String memberName;
    private Boolean isStatic = false;
    private Boolean isAsterisk = false;
    private Position position;

    @Override
    public String toString() {
        return "ImportDTO :{" +
            "importId : " + importId +
            ", blockId : " + blockId +
            ", name : '" + name + '\'' +
            ", packageName : '" + packageName + '\'' +
            ", className : '" + className + '\'' +
            ", memberName : '" + memberName + '\'' +
            ", isStatic : " + isStatic +
            ", isAsterisk : " + isAsterisk +
            ", Position : '" + position +
            "}\n";
    }
}
