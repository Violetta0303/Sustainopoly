package playersInformation;

import org.junit.jupiter.api.Test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: FrameConfigTest
 * @Description:
 * @Author:
 * @Date: 2023-03-14 20:23:59
 */
public class FrameConfigTest {

    @Test
    public void testCreateButton() {
        FrameConfig frameConfig = new FrameConfig();
        JButton jButton = frameConfig.createButton(25, 25, Photo.BUTTON_LEFT, 'a');
        assertEquals(25, jButton.getBounds().height);
    }

    @Test
    public void testAddPlayer01Config() throws NoSuchFieldException, IllegalAccessException {
        FrameConfig frameConfig = new FrameConfig();
        frameConfig.addPlayer01Config(10, 10, new JPanel());
        Field field = frameConfig.getClass().getDeclaredField("jlPlayer01Choose");
        field.setAccessible(true);
        JLabel jLabel = (JLabel) field.get(frameConfig);
        assertEquals(18, jLabel.getBounds().x);
    }

    @Test
    public void testAddPlayer02Config() throws NoSuchFieldException, IllegalAccessException {
        FrameConfig frameConfig = new FrameConfig();
        frameConfig.addPlayer02Config(10, 10, new JPanel());
        Field field = frameConfig.getClass().getDeclaredField("jlPlayer02Choose");
        field.setAccessible(true);
        JLabel jLabel = (JLabel) field.get(frameConfig);
        assertEquals(18, jLabel.getBounds().x);
    }

    @Test
    public void testAddPlayer03Config() throws NoSuchFieldException, IllegalAccessException {
        FrameConfig frameConfig = new FrameConfig();
        frameConfig.addPlayer03Config(10, 10, new JPanel());
        Field field = frameConfig.getClass().getDeclaredField("jlPlayer03Choose");
        field.setAccessible(true);
        JLabel jLabel = (JLabel) field.get(frameConfig);
        assertEquals(18, jLabel.getBounds().x);
    }

    @Test
    public void testAddPlayer04Config() throws NoSuchFieldException, IllegalAccessException {
        FrameConfig frameConfig = new FrameConfig();
        frameConfig.addPlayer04Config(10, 10, new JPanel());
        Field field = frameConfig.getClass().getDeclaredField("jlPlayer04Choose");
        field.setAccessible(true);
        JLabel jLabel = (JLabel) field.get(frameConfig);
        assertEquals(18, jLabel.getBounds().x);
    }

    @Test
    public void testAddPlayer05Config() throws NoSuchFieldException, IllegalAccessException {
        FrameConfig frameConfig = new FrameConfig();
        frameConfig.addPlayer05Config(10, 10, new JPanel());
        Field field = frameConfig.getClass().getDeclaredField("jlPlayer05Choose");
        field.setAccessible(true);
        JLabel jLabel = (JLabel) field.get(frameConfig);
        assertEquals(18, jLabel.getBounds().x);
    }

    @Test
    public void testAddPlayer06Config() throws NoSuchFieldException, IllegalAccessException {
        FrameConfig frameConfig = new FrameConfig();
        frameConfig.addPlayer06Config(10, 10, new JPanel());
        Field field = frameConfig.getClass().getDeclaredField("jlPlayer06Choose");
        field.setAccessible(true);
        JLabel jLabel = (JLabel) field.get(frameConfig);
        assertEquals(18, jLabel.getBounds().x);
    }

    @Test
    public void testAddPlayer07Config() throws NoSuchFieldException, IllegalAccessException {
        FrameConfig frameConfig = new FrameConfig();
        frameConfig.addPlayer07Config(10, 10, new JPanel());
        Field field = frameConfig.getClass().getDeclaredField("jlPlayer07Choose");
        field.setAccessible(true);
        JLabel jLabel = (JLabel) field.get(frameConfig);
        assertEquals(18, jLabel.getBounds().x);
    }

    @Test
    public void testAddPlayer08Config() throws NoSuchFieldException, IllegalAccessException {
        FrameConfig frameConfig = new FrameConfig();
        frameConfig.addPlayer08Config(10, 10, new JPanel());
        Field field = frameConfig.getClass().getDeclaredField("jlPlayer08Choose");
        field.setAccessible(true);
        JLabel jLabel = (JLabel) field.get(frameConfig);
        assertEquals(18, jLabel.getBounds().x);
    }

    @Test
    public void testReload() throws NoSuchFieldException, IllegalAccessException {
        FrameConfig frameConfig = new FrameConfig();
        frameConfig.addPlayer01Config(10, 10, new JPanel());
        frameConfig.addPlayer02Config(10, 10, new JPanel());
        frameConfig.addPlayer03Config(10, 10, new JPanel());
        frameConfig.addPlayer04Config(10, 10, new JPanel());
        frameConfig.addPlayer05Config(10, 10, new JPanel());
        frameConfig.addPlayer06Config(10, 10, new JPanel());
        frameConfig.addPlayer07Config(10, 10, new JPanel());
        frameConfig.addPlayer08Config(10, 10, new JPanel());
        frameConfig.reLoad();
        Field field = frameConfig.getClass().getDeclaredField("jlPlayer01Selected");
        field.setAccessible(true);
        JLabel jLabel = (JLabel) field.get(frameConfig);
        assertEquals(false, jLabel.isVisible());
    }

    @Test
    public void testAddCancelButton() throws NoSuchFieldException, IllegalAccessException {
        FrameConfig frameConfig = new FrameConfig();
        frameConfig.addCancelButton(new JPanel());
        Field field = frameConfig.getClass().getDeclaredField("jbnCancel");
        field.setAccessible(true);
        JButton jButton = (JButton) field.get(frameConfig);
        assertEquals(577, jButton.getBounds().x);
    }

    @Test
    public void testCreatePlayerSelectPanel() throws NoSuchFieldException, IllegalAccessException {
        FrameConfig frameConfig = new FrameConfig();
        frameConfig.createPlayerSelectPanel();
        Field field = frameConfig.getClass().getDeclaredField("jlPlayer01Choose");
        field.setAccessible(true);
        JLabel jLabel = (JLabel) field.get(frameConfig);
        assertEquals(20, jLabel.getBounds().x);
    }

    @Test
    public void testCreateButtonPanel() throws NoSuchFieldException, IllegalAccessException {
        FrameConfig frameConfig = new FrameConfig();
        frameConfig.createButtonPanel();
        Field field = frameConfig.getClass().getDeclaredField("jbnStart");
        field.setAccessible(true);
        JButton jButton = (JButton) field.get(frameConfig);
        assertEquals("Comic Sans MS", jButton.getFont().getName());
    }

    @Test
    public void testInit() throws NoSuchFieldException, IllegalAccessException {
        FrameConfig frameConfig = new FrameConfig();
        frameConfig.init();
        Field field = frameConfig.getClass().getDeclaredField("jf");
        field.setAccessible(true);
        JFrame jFrame = (JFrame) field.get(frameConfig);
        assertEquals(780, jFrame.getSize().width);
    }
}
