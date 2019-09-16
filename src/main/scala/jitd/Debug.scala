package jitd


object Debug extends Enumeration
{

  type Aspect = Value
  val Policy, PolicyDetail = Value

  def fromString(aspect: String) =
    values find { _.toString.toLowerCase.equals(aspect.toLowerCase) }

  def aspectMacro(aspect: Aspect) =
    s"JITD_DEBUG_${aspect.toString.toUpperCase}"

  def onDebug(aspect: Aspect, prefix:String = "")(action: String) =
    s"${prefix}#ifdef ${aspectMacro(aspect)}\n${prefix}$action\n${prefix}#endif"

  def println(aspect: Aspect, prefix: String = "")(message: String) =
    onDebug(aspect, prefix) { 
      "std::cout << \""+message+"\" << std::endl;" 
    }

  def dump(aspect: Aspect, prefix: String = "")(node: String, nodePrefix: String = "") =
    onDebug(aspect, prefix) { 
      "print_JITD_node_structure("+node+", std::string(\""+nodePrefix+"\"));" 
    }
}