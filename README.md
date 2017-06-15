# money-tests
Проект с двумя тестами на успешный логин и успешный разлогин.
Проект пока можно запустить только локально.

Чтобы запустить проект у себя, нужно
1) склонировать проект (git clone https://github.com/lilyYumakaeva/money-tests.git)
2) cd money-tests
3) Для запуска в firefox предполагается, что нужно установить последнюю версию geckodriver [link](https://github.com/mozilla/geckodriver/releases);
для запуска в chrome - последнюю версию chromedriver [link](https://chromedriver.storage.googleapis.com/index.html?path=2.30/);
для запуска в opera - последнюю версию operadriver [link](https://github.com/operasoftware/operachromiumdriver/releases)
4) в файле money-tests/src/main/resources/config.properties нужно указать СВОИ пути до драйверов(или только один - тот, в котором будет запускаться тест) и браузер, в котором хочется запустить тесты
5) из директории money-tests компилируем проект `mvn clean compile`, затем запускаем тесты `mvn test`, затем строим отчет `mvn site`
6) открываем в браузере отчет money-tests/target/site/project-reports.html
