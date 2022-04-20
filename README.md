# TrackEnsureChat
Create chat

Разработать онлайн чат.

Принцип работы чата: при загрузке чата пользователь вводит имя, под которым его сообщения будут видны другим пользователям.
После этого пользователь видит 50 предыдущих сообщений и он получает возможность отправлять сообщения в чат. При отправке сообщения оно должно сохраниться в базе данных. У пользователей должна быть кнопка 'Refresh' чтобы обновить список сообщений.
Нужно разработать модель данных с возможностью масштабирования в будущем.
Для реализации обязательно использовать: Tomcat, Servlet API, Jackson, JDBC. 
Не приветствуется использование Spring Framework, ORM.

Клиентская часть может быть самая примитивная с самыми стандартными элементами.

Дополнительное задание: Реализовать обновление данных у пользователей через вебсокеты (т.е. вебсокет должен работать только на обновление списка сообщений у пользователей чата при новом сообщении).
