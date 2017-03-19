#Bar Graph for Age vs Health Scores
library(ggplot2)
graphtwo<-read.csv("agevscore.csv",TRUE,",")
class(graphtwo)
ggplot(data=graphtwo, aes(x=Age, y=Health.Score)) + geom_bar(stat="identity",width = 0.5,fill = "#00ab57")
