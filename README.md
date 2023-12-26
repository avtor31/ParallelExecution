# ParallelExecution
| Критерии               | CompletableFuture                                        | Spring Reactor                                            |
|-------------------------|----------------------------------------------------------|-----------------------------------------------------------|
| **Асинхронность**        | Полностью поддерживает асинхронное программирование и предоставляет богатые методы для работы с асинхронными задачами. | Специально разработан для реактивного программирования и предоставляет мощные инструменты для работы с асинхронными потоками данных. |
| **Композиция**           | Предоставляет методы для композиции и комбинирования задач, такие как `thenCombine`, `thenApply`, `exceptionally` и др. | Имеет богатые возможности для композиции и комбинирования потоков данных, такие как `flatMap`, `zip`, `concat` и др.              |
| **Обработка исключений** | Предоставляет удобные методы для обработки исключений, такие как `exceptionally`, `handle`, и каскадирование исключений. | Имеет мощные инструменты для обработки исключений в реактивном стиле, такие как `onErrorResume`, `onErrorReturn`, и другие.     |
| **Параллелизм**          | Полностью поддерживает параллелизм и асинхронное выполнение задач. | Разработан с учетом асинхронности и параллелизма, предоставляет операторы для выполнения операций параллельно.              |
| **Callback-и**           | Поддерживает callback-и через методы `thenApply`, `thenAccept`, `thenRun` и другие. | Имеет встроенную поддержку для callback-ов через методы `subscribe`, `onNext`, `onError`, `onComplete` и другие.               |
| **Комплексность**        | Предоставляет более высокий уровень абстракции, что делает код более лаконичным и позволяет эффективно управлять асинхронными операциями. | Также предоставляет высокоуровневые операторы и абстракции для управления реактивными потоками данных.                   |
| **Использование в Spring**| Встроенная поддержка в Spring для асинхронных операций.   | Предоставляет реактивные возможности в Spring для создания асинхронных и отзывчивых систем.                           |

**Когда выбрать CompletableFuture:**
- Когда у вас уже есть существующий код, основанный на `CompletableFuture`, или когда вы работаете в окружении, где `CompletableFuture` более удобен.

**Когда выбрать Spring Reactor:**
- Когда вы разрабатываете новое приложение и хотите использовать реактивный подход от начала до конца.
- Когда вам нужна отзывчивость и управление потоками данных в приложении Spring, особенно при работе с веб-контроллерами и сервисами.
