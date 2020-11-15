walmartapi-up:
	docker run --network host --name walmart_api -p 8081:8081 -d sokar311/walmartapi

walmartapi-image-up:
	docker build -t sokar311/walmartapi .

walmartapi-init:
	./mvnw package -DskipTests
	make walmartapi-image-up
	make walmartapi-up

walmartapi-start:
	docker start walmart_api

walmartapi-stop:
	docker stop walmart_api

walmartapi-rm-container:
	docker rm walmart_api

walmartapi-stop-rm:
	make walmartapi-stop
	make walmartapi-rm-container

walmartapi-rm-image:
	docker rmi sokar311/walmartapi

walmartapi-reset:
	make walmartapi-stop-rm
	make walmartapi-rm-image
	walmartapi-init

walmartapi-uninstall:
	make walmartapi-stop-rm
	make walmartapi-rm-image

walmartapi-run-test:
	./mvnw test