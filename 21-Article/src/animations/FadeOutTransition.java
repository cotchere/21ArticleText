package animations;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.TimelineBuilder;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeOutTransition extends configAnimasi {
	 /**
     * Create new FadeInTransition
     * 
     * @param node The node to affect
     */
    @SuppressWarnings("deprecation")
	public FadeOutTransition(final Node node) {
        super(
            node,
            TimelineBuilder.create()
                .keyFrames(
                    new KeyFrame(Duration.millis(0),    new KeyValue(node.opacityProperty(), 1, WEB_EASE)),
                    new KeyFrame(Duration.millis(500),  new KeyValue(node.opacityProperty(), 0, WEB_EASE))
                )
                .build()
            );
        setCycleDuration(Duration.seconds(1));
        setDelay(Duration.seconds(0.2));
        
    }
}
