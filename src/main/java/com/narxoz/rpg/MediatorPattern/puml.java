@startuml
interface GuildMediator
class GuildHall
abstract class GuildMember
class Quartermaster
class Scout
class Healer
class Captain
class Loremaster

GuildMediator <|.. GuildHall
GuildMember <|-- Quartermaster
GuildMember <|-- Scout
GuildMember <|-- Healer
GuildMember <|-- Captain
GuildMember <|-- Loremaster

GuildMember --> GuildMediator
GuildHall o-- GuildMember

GuildMediator : register(member)
GuildMediator : dispatch(topic, from, payload)
GuildMember : receive(topic, from, payload)
@enduml
