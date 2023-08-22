build:
	docker-compose build

up:
	docker-compose up

down:
	docker-compose down

clean:
	docker-compose down -v

up-db:
	docker-compose up -d postgres