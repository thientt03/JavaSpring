# JavaSpring
Project này là cơ bản thiết yếu API của JavaSpringBoot.
Bao gồm các package: +model
                            +Student.class(tạo đối tượng "học sinh gồm các thuộc tính.....")
                     +dao
                            +StudentDao.inteface(tạo các hàm cần thiết "thêm, sửa, xóa")
                            +FakeStudentImpl.class(lớp fake để test API sẽ k có chi tiết đối tượng thực tế dùng để lấy các đối tượng tương tác dữ liệu với Student)
                     +service
                            +StudentService.class(dùng để thực thi các hàm trong "thêm, sửa, xóa,")
                     +resource
                            +StudentResource.class(controller)

Trong bài này sử dụng @Repository,@Service, @RestController, @RequestMapping, @GetMapping, .... là các component của Spring giúp quản lí các Bean là định hướng xử lí 
