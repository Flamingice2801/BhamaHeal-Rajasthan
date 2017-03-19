
library("sp",lib.loc="/home/yyyshivamyyy/R/x86_64-pc-linux-gnu-library/3.3", quietly=TRUE)
library("RColorBrewer",lib.loc="/home/yyyshivamyyy/R/x86_64-pc-linux-gnu-library/3.3", quietly=TRUE)
ind1=readRDS("/home/yyyshivamyyy/IND_adm1.rds")
ind2=readRDS("/home/yyyshivamyyy/IND_adm2.rds")
rj2 = (ind2[ind2$NAME_1=="Rajasthan",])
rj2$NAME_2 = as.factor(rj2$NAME_2)
col = rainbow(length(levels(rj2$NAME_2)))
rj2$NAME_2 = as.factor(rj2$NAME_2)
rj2$fake.data = runif(length(rj2$NAME_1))
col_no = as.factor(as.numeric(cut(rj2$fake.data, c(0,0.2,0.4,0.6,0.8,1))))
levels(col_no) = c("<20%", "20-40%", "40-60%","60-80%", ">80%")
rj2$col_no = col_no
myPalette = brewer.pal(5,"Greens")
png(filename="/var/www/html/districthealthscore.png",width=700,height=700)
spplot(rj2, "col_no", col=grey(.9), col.regions=myPalette, main="District Wise Health Scores",
       par.settings = list(axis.line = list(col = "transparent")))
graphics.off()
