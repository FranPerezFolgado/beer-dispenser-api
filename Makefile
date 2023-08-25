build:
	docker-compose build

up:
	docker-compose up -d app postgres

down:
	docker-compose down

clean:
	docker-compose down -v

up-db:
	docker-compose up -d postgres

up-app:
	docker-compose up -d app