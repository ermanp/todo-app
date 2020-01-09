# todo-app

Uygulama çalışır durumdadır.

React & spring boot projesidir.

1. Localinizde bir klasör yaratın, 
  burada 'Git Bash Here' diyerek açılan pencerede 'git clone https://github.com/ermanp/todo-app.git' komunu ile projeyi loaclinize çekin.
  veya zip olarak indirin.
  
2. Intellij IDEA'da File-> open -> huawei diyerek projeyi açın.

3. File-> Project Structure -> Project tabinde SDK'nızı 1.8 olacak şekilde ayarlayın

4. Modules tabine gelip backend klasörünü Sources olarak seçin, Apply diyerek çıkın kurulum tamamlanmıştır.

Dependencyleri yükleme

1. pom.xml'de reimport yapın veya IDE'nin sağ tarafındaki Maven tabından +'ya basarak pom.xml'i seçin ardından reimport butonuna basın.
2. command prompt'u admin olarak çalıştırıp veya IDE'nin alt kısmındaki Terminal tabinden todo-app rootuna gidin npm install diyerek dependencyleri indirin.

Application

1. Uygulamada H2 DB kullanıldı, ayağa kalkarken un: erman, password: erman bilgileriyle hazır bir kullanıcı olacak

2. Register için, kullanıcı ad ve şifrenizi belirledikten sonra tekrar logine yönleneceksiniz, yeni kullanıcızla giriş yapabilirsiniz.
