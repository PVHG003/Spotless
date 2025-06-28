FROM ubuntu:latest
LABEL authors="phamh"

ENTRYPOINT ["top", "-b"]