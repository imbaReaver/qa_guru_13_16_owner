package qa.guru.config;

import org.aeonbits.owner.Config;

public interface TypeConfig extends Config {

    @Key("integer")
    Integer getInteger();

    @Key("boolean")
    Boolean getBoolean();

    @Key("double")
    Double getDouble();

    @Key("enum")
    Browser getEnum();
}
