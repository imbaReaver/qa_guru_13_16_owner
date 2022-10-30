package qa.guru;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import qa.guru.config.Browser;
import qa.guru.config.TypeConfig;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TypeTest {

    @Test
    public void testInteger() {
        System.setProperty("integer", "11");
        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getInteger()).isEqualTo(11);

    }

    @Test
    public void testBoolean() {
        System.setProperty("boolean", "true");
        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getBoolean()).isEqualTo(true);
    }

    @Test
    public void testDouble() {
        System.setProperty("double", "44.44");
        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getDouble()).isEqualTo(44.44);

    }

    @Test
    public void testEnum() {
        System.setProperty("enum", "FIREFOX");
        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getEnum()).isEqualTo(Browser.FIREFOX);
    }
}
