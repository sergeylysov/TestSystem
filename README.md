# TestSystem
Приложение реализует простейший REST и SOAP сервис для обучения

По адресу
http://localhost:8080/TestSystem/RestTestSystem
принимает GET и PUT запросы
PUT добавляет объект вида 
{"account":"1234567890123456","balance":100,"firstname":"Иванов","phone":"+71234567890","secondname":"Иванович","surname":"Иван"}
GET отдает такой же объект, если он был предварительно добавлен, иначе выдает 404

По адресу
http://localhost:8080/TestSystem/TestWebService
доступен SOAP web-сервис
wsdl http://localhost:8080/TestSystem/TestWebService?wsdl
Работает с тем же массивом объектов.
т.е. можно добавить объект через REST прочитать через SOAP и наоборот.
Подходит так же для обучения тестированию производительности. Выдерживает приличную нагрузку ~1000 rps

Можно запустить на любом JavaEE (Jakarta) совсестимом веб-сервере, например, GlassFish или Wildfly

Так же приложен Dockerfile для запуска в докере
