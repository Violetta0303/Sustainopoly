package videoplayer;

import sustainopoly.StartGame;
import videoplayer.dll.DLL;
import videoplayer.utils.Constants;
import videoplayer.utils.FileUtils;
import videoplayer.utils.NumberUtil;
import org.apache.commons.lang3.StringUtils;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

import static videoplayer.VideoPlayerMain.videoPlayerFrame;

public class VideoPlayerWindow extends JFrame {
    // private final Logger logger = LoggerFactory.getLogger(Window.class);

    private static final String FIELD_PAUSE = "pause";
    private static final String FIELD_PLAY = "play";

    private static final int PROGRESS_HEIGHT = 10;
    private static final int PROGRESS_MIN_VALUE = 0;
    private static final int PROGRESS_MAX_VALUE = 100;
    private static final int WINDOW_X = 100;
    private static final int WINDOW_Y = 100;
    private static final int WINDOW_WIDTH = 850;
    private static final int WINDOW_HEIGHT = 600;
    private static final int LIST_WINDOW_WIDTH = 200;
    // Total Time
    private static String TOTAL_TIME;
    // Playing speed
    private float speed;
    // First play
    private boolean firstPlay = true;

    // Player components
    private EmbeddedMediaPlayerComponent mediaPlayerComponent;
    // Progress bar
    private JProgressBar progress;
    // Pause button
    private Button pauseButton;
    // Label showing display speed
    private Label displaySpeed;
    // Display Time
    private Label displayTime;
    // Progress timer
    private Timer progressTimer;
    // Continue timer
    private Timer continueTimer;
    // All video paths
    private java.util.List<String> videos;
    // Current position of the playing video
    private int videoIndex;
    // Sound control progress bar
    private JProgressBar volumeProgress;
    // Volume display tab
    private Label volumeLabel;

    private Button previousButton;

    public VideoPlayerWindow() {
        //Set Game's LOGO
        this.setIconImage(new ImageIcon("src/main/java/images/Logo.png").getImage());

        this.videos = new ArrayList<>(10);

        // Set default speed to original speed
        speed = 1.0f;
        // Set window title
        setTitle("VideoPlayer");
        // Set window focus listener event: set default focus to pause button when window opens, when window gets focus
        this.addWindowFocusListener(getWindowFocusListener());

        // Window close event: releases resources and exits the program
//        addWindowListener(closeWindowReleaseMedia());
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                setVisible(false);
            }
        });

        // Set default window close event
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set Window Position
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        // Maximise the display window
        // setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Main Panel
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        // Player Panel
        JPanel player = new JPanel();
        contentPane.add(player, BorderLayout.CENTER);
        contentPane.add(player);
        player.setLayout(new BorderLayout(0, 0));
        // Create the player component and add it to the container
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        player.add(mediaPlayerComponent);
        // Video surface focus listener: set default focus to pause button when surface gets focus
        getVideoSurface().addFocusListener(videoSurfaceFocusAction());

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(bottomPanel, BoxLayout.Y_AXIS);
        bottomPanel.setLayout(boxLayout);
        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        // Progressbar Component Panel
        JPanel progressPanel = new JPanel();
        progress = new JProgressBar();
        progress.setMinimum(PROGRESS_MIN_VALUE);
        progress.setMaximum(PROGRESS_MAX_VALUE);
        progress.setPreferredSize(getNewDimension());
        // Set the progress percentage to be displayed in the middle of the progress bar
        progress.setStringPainted(false);
        // The colour of the progress bar progress
        progress.setForeground(new Color(206, 167, 167));
        // Colour of the progress bar background
        progress.setBackground(new Color(255, 255, 255));

        // Click on the progress bar to adjust the video playback pointer
        progress.addMouseListener(setVideoPlayPoint());
        // Timer
        progressTimer = getProgressTimer();

        progressPanel.add(progress);
        progressPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomPanel.add(progressPanel);
        // contentPane.add(progressPanel, BorderLayout.SOUTH);

        // Button Component Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setBackground(new Color(206, 167, 167));
        bottomPanel.add(buttonPanel);

        // DisplayTime Label
        displayTime = new Label();
        displayTime.setText(getTimeString());
        buttonPanel.add(displayTime);

        Font f = new Font("Arial", Font.ITALIC, 12);

        // Backstory Button
        Button backstoryButton = new Button("Backstory");
        backstoryButton.setFont(f);
        backstoryButton.setBackground(new Color(220, 190, 190));
        backstoryButton.setFocusable(false);
        backstoryButton.addMouseListener(mouseClickedBackstory());
        buttonPanel.add(backstoryButton);

        // Back button, 5 seconds at a time
        Button backButton = new Button("-5s");
        backButton.setFont(f);
        backButton.setBackground(new Color(220, 190, 190));
        backButton.setFocusable(false);
        backButton.addMouseListener(mouseClickedBackVideo());
        buttonPanel.add(backButton);

        // Pause /Play Button
        pauseButton = new Button(FIELD_PLAY);
        pauseButton.setFont(f);
        pauseButton.setBackground(new Color(220, 190, 190));
        pauseButton.setPreferredSize(new Dimension(49, 23));
        pauseButton.addKeyListener(spaceKeyPressMediaPause());
        pauseButton.addMouseListener(mouseClickedMediaPause());
        buttonPanel.add(pauseButton);

        // Forward button, 5 seconds at a time
        Button forwardButton = new Button("+5s");
        forwardButton.setFont(f);
        forwardButton.setBackground(new Color(220, 190, 190));
        forwardButton.setFocusable(false);
        forwardButton.addMouseListener(mouseClickedForwardVideo());
        buttonPanel.add(forwardButton);

        // Eggplot Button
        Button eggplotButton = new Button("Eggplot");
        eggplotButton.setFont(f);
        eggplotButton.setBackground(new Color(220, 190, 190));
        eggplotButton.setFocusable(false);
        eggplotButton.addMouseListener(mouseClickedEggplot());
        buttonPanel.add(eggplotButton);

        // Slow Play button: 0.1 decrement per step, min. 0.5x speed
        Button slowSpeedButton = new Button("<<<");
        slowSpeedButton.setFont(f);
        slowSpeedButton.setBackground(new Color(220, 190, 190));
        slowSpeedButton.setFocusable(false);
        slowSpeedButton.addMouseListener(mouseClickedReducePlaySpeed());
        buttonPanel.add(slowSpeedButton);

        // Reset button: sets the playback speed to the original speed
        Button resetButton = new Button("reset");
        resetButton.setFont(f);
        resetButton.setBackground(new Color(220, 190, 190));
        resetButton.setFocusable(false);
        resetButton.addMouseListener(mouseClickedResetPlaySpeed());
        buttonPanel.add(resetButton);

        // Multiplier button: 0.1 increments at a time, maximum 3x speed
        Button fastSpeedButton = new Button(">>>");
        fastSpeedButton.setFont(f);
        fastSpeedButton.setBackground(new Color(220, 190, 190));
        fastSpeedButton.setFocusable(false);
        fastSpeedButton.addMouseListener(mouseClickedIncreasePlaySpeed());
        buttonPanel.add(fastSpeedButton);

        // Play speed display button
        displaySpeed = new Label();
        displaySpeed.setText("x" + speed);
        displaySpeed.setFocusable(false);
        displaySpeed.setEnabled(false);
        buttonPanel.add(displaySpeed);

        // Add sound control progress bar
        volumeProgress = new JProgressBar();
        volumeProgress.setFocusable(false);
        volumeProgress.setMinimum(0);
        volumeProgress.setMaximum(100);
        volumeProgress.setValue(100);
        volumeProgress.setPreferredSize(new Dimension(100, 10));
        volumeProgress.setBackground(new Color(210, 161, 161));
        volumeProgress.addMouseListener(mouseClickedSetVolumeValue());
        buttonPanel.add(volumeProgress);

        // Volume display
        volumeLabel = new Label();
        volumeLabel.setFocusable(false);
        volumeLabel.setEnabled(false);
        setVolumeLabel(volumeProgress.getValue());
        buttonPanel.add(volumeLabel);

        // Listening to the window size and setting the progress bar width to the window width
        this.addComponentListener(windowResizedResetProgressWidth());
        // Listening for window maximisation and restoration, setting the progress bar width to the window width
        this.addWindowStateListener(windowStateChangedResetProgressWidth());
        // Listening to mouse wheel scrolling and setting volume
        this.addMouseWheelListener(mouseWheelMovedSetVolume());

        continueTimer = getContinueTimer();

        // Set window minimum
        this.setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        this.setLocationRelativeTo(null);

        // Set window visible
        this.setVisible(true);
    }

    /**
     * Reinitialisation video
     *
     * @param offset Offset, 1 for the next video, -1 for the previous video
     */
    private void reInitPlay(int offset) {
        videoIndex += offset;
        if (videoIndex < 0 || videoIndex >= videos.size()) {
            return;
        }
        EmbeddedMediaPlayer mediaPlayer = getMediaPlayer();
        if (!Objects.isNull(mediaPlayer)) {
            mediaPlayer.stop();
        }
        firstPlay = true;
        progressTimer.stop();
        continueTimer.stop();
        initPlay();
    }

    /**
     * Mouse click to rewind the video and go back 5 seconds
     */
    private MouseAdapter mouseClickedBackVideo() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                adaptVideoTime(-5000);
            }
        };
    }

    /**
     * Adjust video time (how many milliseconds forward or backward exactly)
     *
     * @param offset ms
     */
    private void adaptVideoTime(int offset) {
        if (firstPlay) {
            return;
        }
        getMediaPlayer().setTime(getMediaPlayer().getTime() + offset);
    }

    /**
     * Mouse click to advance video, advance 5 seconds
     */
    private MouseAdapter mouseClickedForwardVideo() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                adaptVideoTime(5000);
            }
        };
    }

    /**
     * Get Backstory Video
     */
    private MouseAdapter mouseClickedBackstory() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                videos.add("src/main/java/video/Backstory.mp4");
                videos.sort(Comparator.naturalOrder());
                if (videos.size() <= 1) {
                    previousButton.setEnabled(false);
                } else {
                    previousButton.setEnabled(true);
                }
                if (!Objects.isNull(getMediaPlayer())) {
                    getMediaPlayer().stop();
                }
                pauseButton.setLabel(FIELD_PLAY);
                firstPlay = true;
                setProgress(0, 0);
                progressTimer.stop();
                continueTimer.stop();
                videoIndex = 0;
                preLoading();
            }
        };
    }

    private java.util.List<File> getChooseFiles() {
        System.setProperty(Constants.JNA_ENCODING, Constants.UTF_8);
        String filesPath = DLL.dll.chooseFiles();
        java.util.List<File> list = new ArrayList<>();
        if (StringUtils.isBlank(filesPath) || Constants.FILE_SEPARATOR.equals(filesPath)) {
            return list;
        }
        String[] strings = filesPath.split("\\*\\*\\*");
        for (String str : strings) {
            if (StringUtils.isBlank(str) || Constants.FILE_SEPARATOR.equals(filesPath)) {
                continue;
            }
            list.add(new File(str));
        }
        return list;
    }

    /**
     * Get Eggplot Video
     */
    private MouseAdapter mouseClickedEggplot() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                videos.add("src/main/java/video/EasterEgg.mp4");
                videos.sort(Comparator.naturalOrder());
                if (videos.size() <= 1) {
                    previousButton.setEnabled(false);
                } else {
                    previousButton.setEnabled(true);
                }
                if (!Objects.isNull(getMediaPlayer())) {
                    getMediaPlayer().stop();
                }
                pauseButton.setLabel(FIELD_PLAY);
                firstPlay = true;
                setProgress(0, 0);
                progressTimer.stop();
                continueTimer.stop();
                videoIndex = 0;
                preLoading();
            }
        };
    }

    /**
     * Mouse wheel scroll to set video playback volume from 0% to 100%
     */
    private MouseAdapter mouseWheelMovedSetVolume() {
        return new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int wheelRotation = e.getWheelRotation();
                if (wheelRotation == 1) {
                    setVolume(volumeProgress.getValue() - 5);
                } else if (wheelRotation == -1) {
                    setVolume(volumeProgress.getValue() + 5);
                }
            }
        };
    }

    /**
     * Set the percentage of the current video playback volume label to be displayed
     *
     * @param value Current playback volume, 0-100
     */
    private void setVolumeLabel(int value) {
        volumeLabel.setText(value + "%");
    }

    /**
     * Mouse click to set the video playback volume
     */
    private MouseAdapter mouseClickedSetVolumeValue() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVolume(e.getX());
            }
        };
    }

    /**
     * Set the video playback volume
     *
     * @param value volume, 0-100
     */
    private void setVolume(int value) {
        if (value < 0) {
            value = 0;
        } else if (value > 100) {
            value = 100;
        }
        if (volumeProgress.getValue() == value) {
            return;
        }
        volumeProgress.setValue(value);
        setVolumeLabel(value);
        getMediaPlayer().setVolume(value);
    }

    /**
     * Pre-loaded videos
     */
    private void preLoading() {
        if (videos.isEmpty()) {
            return;
        }
        String path = videos.get(videoIndex);
        setTitle("VideoPlayer-" + FileUtils.getFileName(path) + "(Pre-loaded)");
    }

    /**
     * Initialise video
     */
    private void initPlay() {
        if (videos.isEmpty()) {
            return;
        }
        getMediaPlayer().playMedia(videos.get(videoIndex));
        setWindowTitle();
        String label = pauseButton.getLabel();
        if (!FIELD_PAUSE.equals(label)) {
            pauseButton.setLabel(FIELD_PAUSE);
        }
        setProgress(getMediaPlayer().getTime(), getMediaPlayer().getLength());
        progressTimer.start();
        continueTimer.start();
        this.firstPlay = false;
    }

    /**
     * Set the title of the main window: VideoPlayer-video name
     */
    private void setWindowTitle() {
        String title = getMediaPlayer().getMediaMeta().getTitle();
        setTitle("VideoPlayer-" + title);
    }

    /**
     * Get playtime display string
     *
     * @param curr
     * @param total
     * @return Playback time display string, format00:00:00/00:00:00
     */
    private String getTimeString(long curr, long total) {
        return formatSecond2Time(curr) + " / " + formatSecond2Time(total);
    }

    /**
     * Get playtime display string
     *
     * @return Playback time display string, format00:00:00/00:00:00
     */
    private String getTimeString() {
        setTotalTime();
        return formatSecond2Time(getMediaPlayer().getTime()) + " / " + TOTAL_TIME;
    }

    /**
     * Set the total time in the playtime display string
     */
    private void setTotalTime() {
        if (TOTAL_TIME == null) {
            long totalSecond = getMediaPlayer().getLength();
            TOTAL_TIME = formatSecond2Time(totalSecond);
        }
    }

    /**
     * Format the time and convert seconds into hours, minutes and seconds
     *
     * @param milliseconds
     * @return 00:00:00
     */
    private String formatSecond2Time(long milliseconds) {
        int second = (int) (milliseconds / 1000);
        int h = second / 3600;
        int m = (second % 3600) / 60;
        int s = (second % 3600) % 60;
        return String.format("%02d", h) + ":" + String.format("%02d", m) + ":"
                + String.format("%02d", s);
    }

    /**
     * Video resume timer
     */
    private Timer getContinueTimer() {
        return new Timer(1000, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long total = getMediaPlayer().getLength();
                long curr = getMediaPlayer().getTime();
                if (curr == total) {
                    videoIndex++;
                    if (videoIndex >= videos.size()) {
                        continueTimer.stop();
                        System.out.println("all videos finished...");
                        return;
                    }
                    getMediaPlayer().playMedia(videos.get(videoIndex));
                    setWindowTitle();
                    setProgress(getMediaPlayer().getTime(), getMediaPlayer().getLength());
                    progressTimer.restart();
                }
            }
        });
    }

    /**
     * Video playback progress bar timer
     */
    private Timer getProgressTimer() {
        return new Timer(1000, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getProgress().getValue() >= PROGRESS_MAX_VALUE) {
                    // 结束定时器
                    progressTimer.stop();
                    return;
                }
                // 设置进度值
                setProgress(getMediaPlayer().getTime(), getMediaPlayer().getLength());
            }
        });
    }

    /**
     * Set progress bar
     *
     * @param curr Current time, ms
     * @param total Total time, ms
     */
    private void setProgress(long curr, long total) {
        float percent = (float) curr / total;
        int value = (int) (percent * 100);
        getProgress().setValue(value);
        displayTime.setText(getTimeString(curr, total));
    }

    /**
     * Main window state listener to redraw the progress bar when the window state changes (window reverts to initial state or window is maximised)
     */
    private WindowAdapter windowStateChangedResetProgressWidth() {
        return new WindowAdapter() {
            @Override
            public void windowStateChanged(WindowEvent state) {
                if (state.getNewState() == 0) {
                    setProgressWidthAutoAdaptWindow();
                } else if (state.getNewState() == 6) {
                    setProgressWidthAutoAdaptWindow();
                }
            }
        };
    }

    /**
     * Set the progress bar to adapt to the main window
     */
    private void setProgressWidthAutoAdaptWindow() {
        getProgress().setPreferredSize(getNewDimension());
    }

    /**
     * Listener for main window size change, redraws the progress bar and hides the playlist window when the main window size changes
     */
    private ComponentAdapter windowResizedResetProgressWidth() {
        return new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setProgressWidthAutoAdaptWindow();
            }
        };
    }

    /**
     * Get Shape
     */
    private Dimension getNewDimension() {
        return new Dimension(getWidth(), PROGRESS_HEIGHT);
    }

    /**
     * Set the video playback pointer
     */
    private MouseAdapter setVideoPlayPoint() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                long total = getMediaPlayer().getLength();
                long time = (long) ((float) x / progress.getWidth() * total);
                setProgress(time, total);
                getMediaPlayer().setTime(time);
            }
        };
    }

    /**
     * Video surface focus listener to set the pause button as the default focus of the main window when the video surface acquires focus
     */
    private FocusAdapter videoSurfaceFocusAction() {
        return new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setPauseButtonAsDefaultFocus();
            }
        };
    }

    /**
     * Window closing listener to pause video, release video resources and exit the program when the window is closed
     */
    private WindowAdapter closeWindowReleaseMedia() {
        return new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                getMediaPlayer().stop();
                getMediaPlayer().release();
                System.exit(0);
            }
        };
    }

    /**
     * Mouse click to slow down the playback speed, minus 0.1
     */
    private MouseListener mouseClickedReducePlaySpeed() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (speed <= 0.5f) {
                    speed = 1.0f;
                } else {
                    speed -= 0.1f;
                }
                speed = (float) NumberUtil.formatNumber(speed, 1);
                getMediaPlayer().setRate(speed);
                displaySpeed.setText("x" + speed);
            }
        };
    }

    /**
     * Mouse click to set playback speed, original speed, 1.0x
     */
    private MouseListener mouseClickedResetPlaySpeed() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (speed == 1.0f) {
                    return;
                }
                speed = 1.0f;
                getMediaPlayer().setRate(speed);
                displaySpeed.setText("x" + speed);
            }
        };
    }

    /**
     * Mouse click to increase playback speed, plus 0.1
     */
    private MouseListener mouseClickedIncreasePlaySpeed() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (speed >= 3.0f) {
                    speed = 1.0f;
                } else {
                    speed += 0.1f;
                }
                speed = (float) NumberUtil.formatNumber(speed, 1);
                getMediaPlayer().setRate(speed);
                displaySpeed.setText("x" + speed);
            }
        };
    }

    /**
     * Mouse click to pause the video
     */
    private MouseAdapter mouseClickedMediaPause() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (videos.isEmpty()) {
                    return;
                }
                if (firstPlay) {
                    initPlay();
                    return;
                }
                setMediaStatusAndPauseButton();
                if (progressTimer.isRunning()) {
                    progressTimer.stop();
                } else {
                    progressTimer.restart();
                }
            }
        };
    }

    /**
     * Set the video status (play or pause) and also set the play pause button text
     */
    private void setMediaStatusAndPauseButton() {
        if (getMediaPlayer().isPlaying()) {
            getMediaPlayer().pause();
            pauseButton.setLabel(FIELD_PLAY);
        } else {
            getMediaPlayer().play();
            pauseButton.setLabel(FIELD_PAUSE);
        }
    }

    /**
     * Get the main window focus listener and set the default focus to the play pause button
     */
    private WindowFocusListener getWindowFocusListener() {
        return new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                setPauseButtonAsDefaultFocus();
            }

            @Override
            public void windowGainedFocus(WindowEvent e) {
                setPauseButtonAsDefaultFocus();
            }

            @Override
            public void windowLostFocus(WindowEvent e) {}
        };
    }

    /**
     * Set the default focus to the play pause button
     */
    private void setPauseButtonAsDefaultFocus() {
        pauseButton.requestFocus();
    }

    /**
     * Keyboard space listener to pause or play video when space is pressed, while modifying the play pause button text
     */
    private KeyListener spaceKeyPressMediaPause() {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (videos.isEmpty()) {
                    return;
                }
                if (firstPlay) {
                    initPlay();
                    return;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    setMediaStatusAndPauseButton();
                }
            }
        };
    }

    /**
     * Get progress bar
     */
    private JProgressBar getProgress() {
        return progress;
    }

    /**
     * Get video
     */
    private EmbeddedMediaPlayer getMediaPlayer() {
        return mediaPlayerComponent.getMediaPlayer();
    }

    /**
     * Get the video surface
     */
    private Canvas getVideoSurface() {
        return mediaPlayerComponent.getVideoSurface();
    }

}
