
Editez de fichier de conception au format Markdown 

Vous intégrez des diagrammes UML ainsi :

``` 

```plantuml 
@startuml
abstract class snakeElement
class snakeHead extends snakeElement

class snakeBody extends snakeElement

abstract class Item
class Apple extends Item
class Bonus extends Item

@enduml
```

```plantuml
@startuml

skinparam linetype ortho
package PlayerActions {
    actor Jamy
    usecase quit_app
    usecase open_settings
    usecase edit_settings
    usecase start_game
}

package inGameActions {
    usecase steer_snake
    usecase open_pause_menu
    usecase continue_game
    usecase quit_to_menu
}

Jamy --> start_game
Jamy --> open_settings
open_settings <. edit_settings : include
Jamy --> quit_app

steer_snake ..> start_game : include
open_pause_menu .> start_game : include
open_pause_menu .> continue_game : include
quit_to_menu <. open_pause_menu : include


@enduml
```

```

Attendus : 

- Un diagramme de classe
- Un diagramme de cas d'utilisation