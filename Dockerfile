FROM hseeberger/scala-sbt:8u222_1.3.5_2.13.1

ENV UI_CONFIG=tui

WORKDIR /caro
ADD . /caro
CMD sbt run
