# java 사용 버전
FROM amazoncorretto:17

# 프로젝트가 실행될 위치
WORKDIR /app

# 복사하여 옮김
COPY build/libs/review-0.0.1-SNAPSHOT.jar /app/review.jar
COPY entrypoint.sh /app/entrypoint.sh
RUN chmod +x /app/entrypoint.sh

# 해당 스크립트를 실행
ENTRYPOINT ["/app/entrypoint.sh"]