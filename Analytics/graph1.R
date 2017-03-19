#Bar Graph for Disease Vs Number of People Affected
library(ggplot2)
graphone<-read.csv("ajmer.csv",TRUE,",")
class(graphone)
ggplot(data=graphone, aes(x=Disease, y=No.of.People.Affected)) + geom_bar(stat="identity",width = 0.5,fill = "#00ab57")