package QATest.ui;

import net.serenitybdd.screenplay.targets.Target;

public class Chart {
    public static Target CHART_VALUES = Target.the("Chart Values Above").
                    locatedBy(".highcharts-label tspan:first-of-type");
    public static Target Y_AXIS_LABELS = Target.the("Y Axis Labels").
            locatedBy(".highcharts-yaxis-labels text");
    public static Target CHART_BAR_COLORS = Target.the("Chart Bar Colors")
            .locatedBy(".highcharts-series rect");
    public static Target X_AXIS_LABELS = Target.the("X Axis Labels").
            locatedBy(".highcharts-xaxis-labels text");
}
